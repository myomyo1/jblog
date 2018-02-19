package com.javaex.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;


@Controller
public class BlogController {
	
	@Autowired
	BlogService bservice;
	
	@Autowired
	CategoryService cservice;
	
	@RequestMapping(value="/{id}")
	public String blog(@PathVariable("id") String id, Model model) {
		BlogVo bvo = bservice.getBlogInfo(id);
		model.addAttribute("bvo", bvo); //bvo에는 userNo, blogTitle, logoFile 정보 들어있음
		System.out.println(bvo.toString() + "블로그정보뽑아보기aaaaaaaa"); 
		System.out.println(bvo.getBlogTitle() + "블로그타이틀");
		
		CategoryVo cvo = cservice.getCategoryInfo(bvo.getUserNo());
		model.addAttribute("cvo", cvo);
		System.out.println(cvo.toString() + "카테고리정보뽑아보기bbbbbbbbb");
		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}/admin/basic")
	public String adminbasic(@PathVariable("id") String id, HttpSession session, Model model) {
		
		UserVo loginVo = (UserVo)session.getAttribute("authUser");
		
		model.addAttribute("bvo", bservice.getBlogInfo(id));
		model.addAttribute("cvo", cservice.getCategoryInfo(loginVo.getUserNo()));
		
		return "blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value="/{id}/admin/settingUpdate")
	public String settingUpdate(@PathVariable("id") String id, @RequestParam("userNo")String userNo, @RequestParam("title") String title, @RequestParam("file") MultipartFile file, Model model) {
		//Number는 이미 세션에 authUser에 저장 되어 있음
		System.out.println("update blog Setting start");
		bservice.updateBlogInfo(userNo, title, file);
		
		return "redirect:/"+id;
	}
	
	//이미지 관련 요청 받고 나서 이미지 보여주기
	@RequestMapping(value="/logo/{userNo}")
	public void logoImage(@PathVariable("userNo") String userNo, @RequestParam("logoFile")String logoFile, HttpServletResponse response ) throws IOException {
		
		System.out.println("request image userNo : " + userNo);
		System.out.println("request file name : " + logoFile);
		
		//1. 파일 불러오기 - FileInputStream
		String imageDir = "C:\\myosun\\uploads";
		File file = new File(imageDir+"\\"+logoFile);
		
		//파일이 존재 하지 않으면 기본 이미지로
		if(!file.exists()) {
			new File(imageDir+"\\spring-logo.jpg");
		}
		
		FileInputStream in = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(in);
		
		//response객체에서 OutputStream 꺼내기
		ServletOutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		//꺼내서 전송하기
		 int sendData = -1;
		 byte [] buffer = new byte[65535];
		 while((sendData = bis.read(buffer)) != -1) {
			 out.write(buffer,0,sendData);
		 }
		 
		bos.flush();
		bis.close();
		
		
		
		
	}




}
	
	
	
	
	