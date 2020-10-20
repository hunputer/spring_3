package com.choa.s3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.choa.s3.notice.NoticeDAO;
import com.choa.s3.notice.NoticeDTO;
import com.choa.s3.util.Pager;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void noticeInsertTest() throws Exception{
//		for(int i = 0; i<100; i++) {
//			NoticeDTO noticeDTO = new NoticeDTO();
//			noticeDTO.setTitle("Title" +i);
//			noticeDTO.setContents("Contents" + i);
//			noticeDTO.setWriter("Writer" + i);
//			int result = noticeDAO.noticeWrite(noticeDTO);
//			
//			if(i%10==0) {
//				Thread.sleep(1000);
//			}
//		}
//	}
//	
//	@Test
//	public void noticeSelectTest() throws Exception {
//		System.out.println("select");
//		NoticeDTO noticeDTO = noticeDAO.noticeSelect(4);
//		System.out.println(noticeDTO.getTitle());
//		
//		assertNotNull(noticeDTO);
//	}
//	
//	@Test
//	public void noticeDeleteTest() throws Exception{
//		System.out.println("delete");
//		int result = noticeDAO.noticeDelete(200);
//		System.out.println(result);
//		assertNotEquals(0, result);
//	}
	
//	@Test
//	public void noticeListTest() throws Exception{
//		Pager pager = new Pager();
//		pager.setStartRow(1);
//		pager.setLastRow(10);
//		List<NoticeDTO> ar = noticeDAO.noticeList(pager);
//		System.out.println(ar.size());
//		assertEquals(10, ar.size());
//	}
}
