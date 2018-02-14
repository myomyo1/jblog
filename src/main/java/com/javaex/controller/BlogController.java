package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;


@Controller
public class BlogController {
	
	@Autowired
	BlogService bservice;
	
	@Autowired
	CategoryService cservice;
	
	@RequestMapping(value="/{id}")
	public String blog(@PathVariable("id") String id, Model model) {
		BlogVo bvo = bservice.getBlogInfo(id);
		model.addAttribute("bvo", bvo);
		
		CategoryVo cvo = cservice.getCategoryInfo(bvo.getUserNo());
		model.addAttribute("cvo", cvo);
		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}/admin/basic")
	public String adminbasic(@PathVariable("id") String id) {
		return "blog/admin/blog-admin-basic";
	}

}
