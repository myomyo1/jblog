package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.FileVo;

@Service
public class BlogService {

	@Autowired
	BlogDao bdao;

	public BlogVo getBlogInfo(String id) {
		return bdao.getBlogInFo(id);
	}

	public void updateByTitle(String title, String id) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("id", id);
		bdao.updateByTitle(map);
	}

	public void updateBlogInfo(String userNo, String title, MultipartFile file) {
		String logoFile = updateByFile(file);
		
		BlogVo vo = new BlogVo(Integer.valueOf(userNo), title, logoFile);
		bdao.updateBlogSetting(vo);
	}

	private String updateByFile(MultipartFile file) {

		System.out.println("파일 업로드 시작");
		
		// 카피하는일
		String saveDir = "C:\\myosun\\uploads";

		// 파일정보 수집

		// 원래파일이름
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);
		// 확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(exName);
		// 저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);
		// 파일저장위치(path)
		String filePath = saveDir + "\\" + saveName;
		System.out.println(filePath);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);

		// vo만들어서 dao통해서 DB에 저장
		// FileVo fvo = new FileVo(orgName, exName, saveName, filePath, fileSize);
		// bdao.updateByFile(fvo);

		// 파일카피
		try {
			byte[] fileData = file.getBytes(); // 바이트단위로 파일을 읽어서 배열에 담아 둠.
			OutputStream out = new FileOutputStream(saveDir + "/" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);

			bout.write(fileData);

			if (bout != null) {
				bout.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("파일 업로드 완료" + saveName);
		return saveName;
	}

}
