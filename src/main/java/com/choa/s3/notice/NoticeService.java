package com.choa.s3.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s3.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public int noticeUpdate(NoticeDTO noticeDTO) {
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	
	public int noticeDelete(long num) throws Exception{
		return noticeDAO.noticeDelete(num);
	}
	
	public List<NoticeDTO> noticeList() throws Exception {
		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		ar = noticeDAO.noticeList();
		return ar;
	}
	
	public List<NoticeDTO> noticeList(Pager pager) throws Exception {
		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		pager.makeRow();
		ar = noticeDAO.noticeList(pager);
		pager.setTotalCount(noticeDAO.noticeCount(pager));
		pager.makePage();
		return ar;
	}
	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeWrite(noticeDTO);
	}
	
	public NoticeDTO noticeSelect(long num) throws Exception{
		return noticeDAO.noticeSelect(num); 
	}
}
