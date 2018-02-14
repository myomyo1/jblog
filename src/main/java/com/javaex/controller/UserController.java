package com.javaex.controller;

import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@RequestMapping("/joinForm")
	public String joinform() {
		return "user/joinForm";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo uservo) { //id, userName, password 받아서 joinvo에 넣은 것 
		uservice.join(uservo); //회원가입
		return "user/joinSuccess";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session) { //id, pw를 Map으로 받아옴
		UserVo authUser = uservice.login(map);
		if(authUser!=null) {
			session.setAttribute("authUser", authUser);
			return "main/index";
		}else {
			//return "redirect:/user/loginForm?result=fail";  
			//map에 담긴 id값을 넘겨서 loginFrom.jsp에서 id값을 value="${param.id}로 받으면 로그인 실패시에도 아이디 그대로 남아있을 수 있다.
			return "redirect:/user/loginForm?result=fail&id="+map.get("id"); 	
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main/index";
	}
}
