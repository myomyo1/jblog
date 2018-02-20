package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Repository
public class BlogDao {
	
	@Autowired
	SqlSession session;
	//userservice에 자동연결되서 디폴트 블로그 생성한것. 
	public void createblog(UserVo uservo) {
		session.insert("blog.createblog",uservo);
	}

	public BlogVo getBlogInFo(String id) {
		return session.selectOne("blog.getBlogInfo",id);
		
	}
	
	public void updateBlogSetting(BlogVo bvo) {
		session.update("blog.updateBlogSetting", bvo);
	}
	

	



}
