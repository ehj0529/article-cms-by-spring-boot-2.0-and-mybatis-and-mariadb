package com.sbs.starter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sbs.starter.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	public List<Article> getList(){
		//중간 확인 데이터.
		Article article1 = new Article(1,"2020-04-01 01:01:01","제목1","내용1");
		Article article2 = new Article(2,"2020-04-02 01:01:01","제목2","내용2");
		Article article3 = new Article(3,"2020-04-03 01:01:01","제목3","내용3");
		Article article4 = new Article(4,"2020-04-04 01:01:01","제목4","내용4");
		
		List<Article> list = new ArrayList<>();
		
		list.add(article1);
		list.add(article2);
		list.add(article3);
		list.add(article4);
		
		return list;
	}

}
