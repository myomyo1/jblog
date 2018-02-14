package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;


@Repository
public class CategoryDao {

	@Autowired
	SqlSession session;
	
	public void createcategory(int userNo) {
		session.insert("cate.createCategory",userNo);
	}

	public CategoryVo getCategoryInfo(int userNo) {
		return session.selectOne("cate.getCategoryInfo", userNo);
	}
}
