package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;

@Service
public class PostService {
	
	@Autowired
	PostDao pdao;

	public void posting(Map<String, String> map) {
		System.out.println("postservice에서 map정보 : " + map);
		pdao.posting(map);	
	}

}
