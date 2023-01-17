package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.MemberService;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService memberService;
	@RequestMapping("/memberWrite.do")
	public String memberWrite() {
		
		return "member/memberWrite";
	}

	@RequestMapping("/idcheck.do")
	@ResponseBody
	public String idCheck(String userId) throws Exception{
		String msg = "";
		int result = memberService.idCheck(userId);
		
		if(result == 0) msg = "ok";
		return msg;
	}
	
	@RequestMapping("/post1.do")
	public String post1() {
		return "member/post1";
	}
	
	@RequestMapping("/post2.do")
	public String post2(String dong, ModelMap model) throws Exception {
		List<?> list = memberService.selectPostList(dong);
		model.addAttribute("dongList", list);
		return "member/post2";
	}
	
}
