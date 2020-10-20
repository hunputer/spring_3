package com.choa.s3.member;

import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s3.util.Pager;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberList")
	public ModelAndView memberList(Pager pager) throws Exception {
		List<MemberDTO> lists = memberService.memberList(pager);
		System.out.println(lists.size());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberList");
		mv.addObject("lists", lists);
		mv.addObject("pager", pager);
		return mv;
	}
	
	@RequestMapping(value="memberJoin")
	public String memberJoin() {
		return "member/memberJoin";
	}
	
	@RequestMapping(value="memberJoin" , method=RequestMethod.POST)
	public ModelAndView memberJoin(MemberDTO memberDTO) {
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberJoin(memberDTO);
		String msg = "join fail";
		if(result > 0) {
			msg = "join success";
		}
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path","./memberList");
		return mv;
	}
	
	@RequestMapping(value = "memberSelect")
	public ModelAndView memberSelect(long num) {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = memberService.memberSelect(num);
		mv.setViewName("member/memberSelect");
		mv.addObject("dto", memberDTO);
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public ModelAndView memberUpdate(long num) {
		MemberDTO memberDTO = memberService.memberSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(MemberDTO memberDTO) {
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberUpdate(memberDTO);
		String msg = "update fail";
		if(result > 0) {
			msg = "update success";
		}
		mv.setViewName("common/result");
		mv.addObject("path", "./memberList");
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(long num) {
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberDelete(num);
		String msg = "delete fail";
		if(result > 0) {
			msg = "delete success";
		}
		mv.setViewName("common/result");
		mv.addObject("path", "./memberList");
		mv.addObject("msg", msg);
		return mv;
	}
}
