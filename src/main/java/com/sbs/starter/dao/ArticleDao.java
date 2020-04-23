package com.sbs.starter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.sbs.starter.dto.Article;

@Mapper //ArticleDao의 구현체를 마이바티스가 대신 구현해준다.
public interface ArticleDao {
	
	public List<Article> getList();

	public long add(Map<String, Object> param);

	public int getTotalCount();

	public Article getOne(long id);

	public void delete(long id);

	public long modify(Map<String, Object> param);

	public void hitUp(long id);
	
}
