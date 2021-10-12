package com.project.chatbot.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.domain.StoreVO;
import com.project.chatbot.service.StoreService;

@Repository
public class StoreDAOImpl implements StoreDAO {
	
	private SqlSession sqlSession;
	private String NAMESPACE="com.project.chatbot.mappers.store.storeMapper";
	
	@Inject
	public StoreDAOImpl(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public StoreVO storefind(StoreDTO storeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".storefind",storeDTO);
	}
	
	public void storefind(int storeno) {

	}
}