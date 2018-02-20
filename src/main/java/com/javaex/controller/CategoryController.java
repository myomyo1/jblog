package com.javaex.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.CategoryService;
import com.javaex.vo.UserVo;

@Controller
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@RequestMapping(value="/{id}/admin/category")
	public String category(@PathVariable("id") String id) {
		return "blog/admin/blog-admin-cate";
	}
}