package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired	
	UserDao udao;
	@Autowired
	BlogDao bdao;
	@Autowired
	CategoryDao cdao;

	public void join(UserVo uservo) {
		System.out.println("서비스 전 :" + uservo.toString());
		udao.join(uservo); //회원가입 
		System.out.println("서비스 후 :" + uservo.toString());
		//userno 가지고 와서 블로그, 카테고리 만들기
		bdao.createblog(uservo);
		cdao.createcategory(uservo.getUserNo()); 
	}

	public UserVo login(Map<String, String> map) { //id, pw가지고 있는 map
		return  udao.login(map);
	}
	


}
