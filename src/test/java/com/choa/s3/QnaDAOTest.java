package com.choa.s3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.choa.s3.notice.NoticeDAO;
import com.choa.s3.notice.NoticeDTO;
import com.choa.s3.qna.QnaDAO;
import com.choa.s3.qna.QnaDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class QnaDAOTest {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void noticeInsertTest() throws Exception{
		for(int i = 0; i<100; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle("Title" +i);
			qnaDTO.setContents("Contents" + i);
			qnaDTO.setWriter("Writer" + i);
			int result = qnaDAO.qnaWrite(qnaDTO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
	} 
	
}
