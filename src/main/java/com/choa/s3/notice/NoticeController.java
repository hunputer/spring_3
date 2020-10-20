package com.choa.s3.notice;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s3.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	public NoticeService noticeService;
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView noticeUpdate(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		NoticeDTO noticeDTO = noticeService.noticeSelect(num);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("notice/noticeUpdate");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeUpdate(noticeDTO);
		String msg = "update fail";
		if(result > 0) {
			msg = "update success";
		}
		mv.setViewName("common/result");
		mv.addObject("msg",msg);
		mv.addObject("path","./noticeList");
		return mv;
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView noticeDelete(long num) throws Exception{
		System.out.println("Notice Delete Controller");
		int result = noticeService.noticeDelete(num);
		String message = "Delete Fail";
		if(result > 0) {
			message = "Delete Success";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		return mv;
	}
	
	@RequestMapping(value = "noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception{
		System.out.println("kind : " + pager.getKind());
		System.out.println("search : " + pager.getSearch());
		
		int curPage = pager.getCurPage();
		
		ModelAndView mv = new ModelAndView();
		
		List<NoticeDTO> ar = noticeService.noticeList(pager);
		
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		mv.setViewName("notice/noticeList");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView noticeWrite() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeWrite");
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./noticeList");
		noticeService.noticeWrite(noticeDTO);
		return mv;
	}
	
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView noticeSelect(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeSelect");
		NoticeDTO noticeDTO = noticeService.noticeSelect(num);
		mv.addObject("dto", noticeDTO);
		return mv;
	}
}
