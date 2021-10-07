package com.project.chatbot.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.chatbot.doman.StoreVO;

@Repository
public class StoreDAOImpl implements StoreDAO{
	
	private static final String namespace="com.project.chatbot.mappers.store.storeMapper";
	private SqlSession sqlSession;
	
	@Inject
	public StoreDAOImpl(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public List<StoreVO> storelist() throws Exception {
		return sqlSession.selectList(namespace+".selectStore");
	}

}
