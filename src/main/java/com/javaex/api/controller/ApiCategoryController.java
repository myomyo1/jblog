package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;


@Controller
public class ApiCategoryController {

	@Autowired
	CategoryService cservice;
	
	@ResponseBody
	@RequestMapping(value="/admin/categorylist", method=RequestMethod.POST)
	public List<CategoryVo> category(@RequestBody UserVo userVo) {
		return cservice.getCategoryList(userVo.getUserNo());
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/categoryAdd", method = RequestMethod.POST)
	public CategoryVo categoryAdd(@RequestBody CategoryVo cvo) {
		System.out.println(cvo.toString());
		cservice.categoryAdd(cvo);
		return cvo;
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/categoryDelete", method = RequestMethod.POST)
	public int categoryDelete(@RequestBody int cateNo) {
		System.out.println("delete 진입" + cateNo);
		return cservice.categoryDelete(cateNo);
	}
	
}
