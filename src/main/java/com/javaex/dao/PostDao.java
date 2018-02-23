package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	SqlSession session;

	public void posting(Map<String, String> map) {
		session.insert("post.posting", map);
	}

	public List<PostVo> getPostList(String id) {
		return session.selectList("post.getPostList",id);
		
	}
	
}
