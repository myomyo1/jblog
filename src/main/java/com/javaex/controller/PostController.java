package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService pservice;
	
	@RequestMapping(value="/{id}/admin/write")
	public String adminbasic(@PathVariable("id") String id) {
		
/*		UserVo loginVo = (UserVo)session.getAttribute("authUser");
		
		model.addAttribute("bvo", bservice.getBlogInfo(id));
		model.addAttribute("cvo", cservice.getCategoryInfo(loginVo.getUserNo()));*/
		
		return "blog/admin/blog-admin-write";
	
}

}
