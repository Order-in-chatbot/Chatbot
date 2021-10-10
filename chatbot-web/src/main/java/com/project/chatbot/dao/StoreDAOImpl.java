package com.project.chatbot.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.domain.StoreVO;



@Repository
public class StoreDAOImpl implements StoreDAO {
	//데이터베이스 데이터 접근 객체
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="com.project.chstbot.store.storeMapper";
	
	@Inject
	public StoreDAOImpl(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	//store find
	@Override
	public StoreVO storefind(StoreDTO storeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".storefind",storeDTO);
	}

	
	

}
