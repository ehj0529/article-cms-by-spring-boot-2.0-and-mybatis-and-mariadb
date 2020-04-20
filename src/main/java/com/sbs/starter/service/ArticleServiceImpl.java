package com.sbs.starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.starter.dao.ArticleDao;
import com.sbs.starter.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	ArticleDao articleDao;

	//ArticleService 데이터 내용은 Dao에게 위임
	
	public List<Article> getList(){

			return articleDao.getList();
	}

}