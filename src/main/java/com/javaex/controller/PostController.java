package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.PostService;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Controller
public class PostController {
	
	@Autowired
	BlogService bservice;
	@Autowired
	CategoryService cservice;
	@Autowired
	PostService pservice;
	

	
	@RequestMapping(value="/{id}/admin/write")
	public String adminbasic(@PathVariable("id") String id, HttpSession session, Model model) {
		
		UserVo loginVo = (UserVo)session.getAttribute("authUser");
		
		model.addAttribute("bvo", bservice.getBlogInfo(id));
		List<CategoryVo> clist =cservice.getCategoryList(loginVo.getUserNo());
		model.addAttribute("clist", clist);
				
		return "blog/admin/blog-admin-write";
	}
	
	@RequestMapping(value="/{id}/admin/posting")
	public String posting(@PathVariable("id") String id, 
						  @RequestParam("title") String title,
						  @RequestParam("content") String content,
						  @RequestParam("category") String cateNo ) {
		System.out.println("postcontroller로 파라미터받아오는지: " + id + title + content);
		Map<String, String> map = new HashMap<String,String>();
		//map.put("id", id);
		map.put("title", title);
		map.put("content", content);
		map.put("cateNo", cateNo);
		pservice.posting(map);
		System.out.println("map 정보 : " + map);
		return "redirect:/{id}/admin/write";
	}

}
