package com.choa.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s3.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public int qnaReply(QnaDTO qnaDTO) {
		QnaDTO parent = qnaDAO.qnaSelect(qnaDTO.getNum());
		int result = qnaDAO.qnaReplyUpdate(parent);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		return qnaDAO.qnaReply(qnaDTO);
	}
	
	public List<QnaDTO> qnaList(Pager pager) {
		pager.makeRow();
		long total = qnaDAO.qnaCount(pager);
		pager.setTotalCount(total);
		pager.makePage();
		List<QnaDTO> ar = qnaDAO.qnaList(pager);
		return ar;
	}
	
	public QnaDTO qnaSelect(long num) {
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaUpdate(QnaDTO qnaDTO) {
		return qnaDAO.qnaUpdate(qnaDTO);
	}
	
	public int qnaDelete(long num) {
		return qnaDAO.qnaDelete(num);
	}
	
	public int qnaWrite(QnaDTO qnaDTO) {
		return qnaDAO.qnaWrite(qnaDTO);
	}
}
