package com.choa.s3.qna;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s3.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public ModelAndView qnaList(Pager pager) {
		List<QnaDTO> ar = qnaService.qnaList(pager);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("qna/qnaList");
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		return mv;
	}
	
	@RequestMapping(value="qnaSelect")
	public ModelAndView qnaList(long num) {
		ModelAndView mv = new ModelAndView();
		QnaDTO qnaDTO = qnaService.qnaSelect(num);
		mv.setViewName("qna/qnaSelect");
		mv.addObject("dto", qnaDTO);
		return mv;
	}
	
	@RequestMapping(value="qnaUpdate" , method = RequestMethod.GET)
	public ModelAndView qnaUpdate(long num) {
		QnaDTO dto = qnaService.qnaSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("qna/qnaUpdate");
		mv.addObject("dto", dto);
		return mv;
	}
	
	@RequestMapping(value="qnaUpdate" , method = RequestMethod.POST)
	public ModelAndView qnaUpdate(QnaDTO qnaDTO) {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaUpdate(qnaDTO);
		String msg = "Update Fail";
		if(result > 0) {
			msg = "Update Success";
		}
		
		mv.addObject("path", "./qnaList");
		mv.addObject("msg", msg);
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="qnaDelete")
	public ModelAndView qnaDelete(long num) {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaDelete(num);
		String msg = "Delete Fail";
		if(result > 0) {
			msg = "Delete Success";
		}
		
		mv.addObject("path", "./qnaList");
		mv.addObject("msg", msg);
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="qnaWrite")
	public ModelAndView qnaWrite() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("qna/qnaWrite");
		return mv;
	}
	
	@RequestMapping(value="qnaWrite" , method=RequestMethod.POST)
	public ModelAndView qnaWrite(QnaDTO qnaDTO) {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaWrite(qnaDTO);
		String msg = "Insert Fail";
		if(result > 0) {
			msg = "Insert Success";
		}
		
		mv.addObject("path", "./qnaList");
		mv.addObject("msg", msg);
		mv.setViewName("common/result");
		return mv;
	}
	
}
