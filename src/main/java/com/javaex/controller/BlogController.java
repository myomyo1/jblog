package com.javaex.controller;

import java.util.List;

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
		
		List<CategoryVo> clist= cservice.getCategoryList(bvo.getUserNo());
		model.addAttribute("clist", clist);
		System.out.println(clist + "카테고리정보뽑아보기bbbbbbbbb");
		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}/admin/basic")
	public String adminbasic(@PathVariable("id") String id, HttpSession session, Model model) {
		
		UserVo loginVo = (UserVo)session.getAttribute("authUser");
		
		model.addAttribute("bvo", bservice.getBlogInfo(id));
		model.addAttribute("cvo", cservice.getCategoryList(loginVo.getUserNo()));
		
		return "blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value="/{id}/admin/updateBlogSetting")
	public String updateBlogSetting(@PathVariable("id") String id, 
									@RequestParam(value="title", required=false, defaultValue="") String title, 
									@RequestParam(value="file", required=false, defaultValue="") MultipartFile file,
									HttpSession session,
									Model model ) {
		System.out.println("update blog Setting start");
		UserVo loginVo =(UserVo)session.getAttribute("authUser");
		int userNo = loginVo.getUserNo();
		bservice.updateBlogSetting(userNo, title, file);
		
		return "redirect:/"+id;
	}
	

}
	
	
	
	
	