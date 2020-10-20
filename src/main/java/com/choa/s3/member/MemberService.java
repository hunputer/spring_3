package com.choa.s3.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s3.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> memberList(Pager pager){
		pager.makeRow();
		List<MemberDTO> ar = memberDAO.memberList(pager);
		pager.setTotalCount(memberDAO.memberCount(pager));
		pager.makePage();
		return ar;
	}
	
	public int memberJoin(MemberDTO memberDTO) {
		return memberDAO.memberJoin(memberDTO);
	}
	
	public MemberDTO memberSelect(long num) {
		return memberDAO.memberSelect(num);
	}
	
	public int memberUpdate(MemberDTO memberDTO) {
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public int memberDelete(long num) {
		return memberDAO.memberDelete(num);
	}
	
}
