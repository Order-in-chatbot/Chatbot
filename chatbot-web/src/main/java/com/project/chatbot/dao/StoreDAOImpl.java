package com.project.chatbot.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.chatbot.domain.StoreVO;
import com.project.chatbot.service.StoreService;

@Repository
public class StoreDAOImpl implements StoreDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	
	@Override
	public String storefind(int storeno){
		return  sqlSessionTemplate.selectOne("storefind",storeno);
}
	
	@Override
	public List<StoreVO> list(){
		return sqlSessionTemplate.selectList("list");
	}
}