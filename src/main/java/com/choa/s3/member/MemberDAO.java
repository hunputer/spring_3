package com.choa.s3.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.s3.util.Pager;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.choa.s3.member.MemberDAO.";
	
	public List<MemberDTO> memberList(Pager pager){
		return sqlSession.selectList(namespace+"memberList", pager);
	}
	
	public long memberCount(Pager pager) {
		return sqlSession.selectOne(namespace+"memberCount", pager);
	}
	
	public int memberJoin(MemberDTO memberDTO) {
		return sqlSession.insert(namespace+"memberJoin", memberDTO);
	}
	
	public MemberDTO memberSelect(long num) {
		return sqlSession.selectOne(namespace+"memberSelect", num);
	}
	
	public int memberUpdate(MemberDTO memberDTO) {
		return sqlSession.update(namespace+"memberUpdate", memberDTO);
	}
	
	public int memberDelete(long num) {
		return sqlSession.delete(namespace+"memberDelete", num);
	}
}
