package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao cdao;
	
	public CategoryVo getCategoryInfo(int userNo) {
		return cdao.getCategoryInfo(userNo);
	}

}
