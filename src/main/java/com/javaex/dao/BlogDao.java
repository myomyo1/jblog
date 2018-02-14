package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	SqlSession session;
	//userservice에 자동연결되서 디폴트 블로그 생성한것. 
	public void createblog(int userNo) {
		session.insert("blog.createblog",userNo);
	}

	public BlogVo getBlogInFo(String id) {
		return session.selectOne("blog.getBlogInfo",id);
		
	}



}
