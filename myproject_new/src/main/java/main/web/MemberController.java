package main.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.MemberService;
import main.service.MemberVO;

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
	
	@RequestMapping("/memberWriteSave.do")
	@ResponseBody
	public String memberWriteSave(MemberVO vo) {
		String msg = "";
		try {
			System.out.println("생일 =>"+ vo.getBirth());
			String result = memberService.insertMember(vo);
			if(result == null) msg = "ok"; 
			else msg = "fail";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return msg;
	}
	
	@RequestMapping("/loginWrite.do")
	public String loginWrite() {
		
		return "member/loginWrite";
	}
	
	@RequestMapping("/loginWriteSub.do")
	@ResponseBody
	public String loginProcessing(MemberVO vo, HttpSession session) throws Exception {
		String msg = "";
		int count = memberService.selectMemberCount(vo);
		if(count == 1) {
			//session 생성
			session.setAttribute("SessionUserID", vo.getUserid());
			//message 처리
			msg = "ok";
		}
		return msg;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		
		session.removeAttribute("SessionUserID");
		
		return "member/loginWrite";
	}
	
}
