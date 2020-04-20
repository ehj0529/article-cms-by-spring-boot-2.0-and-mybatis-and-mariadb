package com.sbs.starter.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sbs.starter.dto.Article;

@Component //이렇게해야 AutoWired에 의한 연결에 적용됨.
public class ArticleDaoImpl implements ArticleDao{
	
	public List<Article> getList(){
		//중간 확인 데이터.
		Article article1 = new Article(1,"2020-04-01 01:01:01","Title 1","Desc 1");
		Article article2 = new Article(2,"2020-04-02 01:01:01","Title 2","Desc 2");
		Article article3 = new Article(3,"2020-04-03 01:01:01","Title 3","Desc 3");
		Article article4 = new Article(4,"2020-04-04 01:01:01","Title 4","Desc 4");
		
		List<Article> list = new ArrayList<>();
		
		list.add(article1);
		list.add(article2);
		list.add(article3);
		list.add(article4);
		
		return list;
	}
}
