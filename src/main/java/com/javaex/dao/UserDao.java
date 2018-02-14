package com.javaex.dao;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	SqlSession session;

	public void join(UserVo uservo) {
		System.out.println("전 : " + uservo.toString());
		session.insert("user.join",uservo);
		System.out.println("후 : " +uservo.toString());
	}
	

	public UserVo login(Map<String, String> map) {
		return session.selectOne("user.loginByIdAndPw", map);
	}




	

}
