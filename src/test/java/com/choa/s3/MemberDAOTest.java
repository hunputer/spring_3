/**
 * 
 */
package com.choa.s3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.choa.s3.member.MemberDAO;
import com.choa.s3.member.MemberDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemberDAOTest {

	@Autowired
	public MemberDAO memberDAO;
	
	@Test
	public void memberSelectTest() {
		MemberDTO memberDTO = memberDAO.memberSelect(13);
		
		assertNotNull(memberDTO);
	}

}
