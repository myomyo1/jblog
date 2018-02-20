package com.javaex.dao;

import java.util.List;

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

/*	public CategoryVo getCategoryInfo(int userNo) {
		return session.selectOne("cate.getCategoryInfo", userNo);
	}*/

	public List<CategoryVo> getCategoryList(int userNo) {
		return session.selectList("cate.getCategoryList", userNo);
	}
	//	xml 에서 <select id="getCategoryList" resultType="CategoryVo">
	// 리절트타입이 vo
	// vo가  selectlist에 담겨서 들어오는 것 

	public void addCategory(CategoryVo cvo) {
		session.insert("cate.addCategory", cvo);
	}

	public int deleteCategory(int cateNo) {
		return session.delete("cate.deleteCategory",cateNo);
	}



}
