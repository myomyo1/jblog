package com.javaex.controller;

import javax.servlet.annotation.MultipartConfig;
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
	public String settingUpdate(@PathVariable("id") String id, @RequestParam("title") String title, @RequestParam("file") MultipartFile file, Model model) {
		
		//블로그제목
		bservice.updateByTitle(title, id);
		
		//로고이미지
		String saveName = bservice.updateByFile(file);
		String url = "upload/"+ saveName; //jsp에게 보낼때 dispatcherServlet필요 (모델에담아보내면됨)
		model.addAttribute("url", url); //DS가 result.jsp로 보내줌
		
		return "redirect:/blog/admin/blog-admin-basic";
	}




}
	
	
	
	
	