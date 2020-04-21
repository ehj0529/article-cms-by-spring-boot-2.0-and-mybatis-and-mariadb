package com.sbs.starter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String showList(Model aModel) {
		
		List<Article> list = articleService.getList();
		int totalCount = articleService.getTotalCount();
		
		
		aModel.addAttribute("list", list);
		aModel.addAttribute("totalCount", totalCount);
		
		
		return "article/list";
	}
	
	@RequestMapping("/article/add")
	public String showAdd() {
		return "article/add";
	}


	@RequestMapping("/article/doAdd")
	@ResponseBody
	public String doAdd(@RequestParam Map<String, Object> param) { //String title, String body

		long newId = articleService.add(param);
		return newId +"번 게시물이 추가되었습니다.";
		
	}


}
