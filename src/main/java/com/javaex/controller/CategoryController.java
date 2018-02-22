package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class CategoryController {

	@Autowired
	BlogService bservice;
	
	@RequestMapping(value="/{id}/admin/category")
	public String category(@PathVariable("id") String id, Model model) {
		BlogVo bvo=bservice.getBlogInfo(id);
		model.addAttribute("bvo", bvo);
		return "blog/admin/blog-admin-cate";
	}
}