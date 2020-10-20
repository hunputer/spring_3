package com.choa.s3.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.s3.util.Pager;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.choa.s3.qna.QnaDAO.";
	
	public List<QnaDTO> qnaList(Pager pager){
		return sqlSession.selectList(namespace+"qnaList", pager);
	}
	
	public QnaDTO qnaSelect(long num) {
		return sqlSession.selectOne(namespace+"qnaSelect",num);
	}
	
	public int qnaUpdate(QnaDTO qnaDTO) {
		return sqlSession.update(namespace+"qnaUpdate", qnaDTO);
	}
	
	public int qnaDelete(long num) {
		return sqlSession.delete(namespace+"qnaDelete", num);
	}
	
	public int qnaWrite(QnaDTO qnaDTO) {
		return sqlSession.insert(namespace+"qnaWrite", qnaDTO);
	}
	
	public long qnaCount(Pager pager) {
		return sqlSession.selectOne(namespace+"qnaCount", pager);
	}
}
