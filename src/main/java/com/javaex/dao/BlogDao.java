package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.BlogVo;
import com.javaex.vo.FileVo;
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
	
	public void updateByTitle(Map<String, String> map) {
		session.update("blog.updateByTitle", map);
	}
	
	public void updateByFile(FileVo fvo) {
		session.update("blog.updateByFile", fvo);
	}

	



}
