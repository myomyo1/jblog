package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.CategoryService;
import com.javaex.vo.UserVo;

@Controller
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@RequestMapping(value="/{id}/admin/category")
	public String adminbasic(@PathVariable("id") String id) {
		
/*		UserVo loginVo = (UserVo)session.getAttribute("authUser");
		
		model.addAttribute("bvo", bservice.getBlogInfo(id));
		model.addAttribute("cvo", cservice.getCategoryInfo(loginVo.getUserNo()));*/
		
		return "blog/admin/blog-admin-cate";
	
}
}