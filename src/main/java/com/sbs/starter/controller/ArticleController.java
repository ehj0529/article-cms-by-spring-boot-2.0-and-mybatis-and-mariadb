package com.sbs.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.starter.dto.Article;
import com.sbs.starter.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j   //롬복 로그 log.info 사용가능함.
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/list")
	public String showList() {
		
		List<Article> list = articleService.getList();
		
		log.info("list: "+list);
		
		return "article/list";
	}
	
}
