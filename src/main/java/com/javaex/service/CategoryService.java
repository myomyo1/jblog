package com.javaex.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;


@Service
public class CategoryService {
	
	@Autowired
	CategoryDao cdao;
	
	public List<CategoryVo> getCategoryList(int userNo) {
		return cdao.getCategoryList(userNo);
	}

	public void categoryAdd(CategoryVo cvo) {
		cdao.addCategory(cvo);
	}

	public int categoryDelete(int cateNo) {
		return cdao.deleteCategory(cateNo);
		
	}

}
