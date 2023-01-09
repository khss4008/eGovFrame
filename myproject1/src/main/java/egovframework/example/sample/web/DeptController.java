package egovframework.example.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {
	
	@RequestMapping(value = "/deptWrite.do")
	public String deptWrite() {
		
		
		return "dept/deptWrite";
	}

	@RequestMapping(value = "/deptWriteSave.do")
	public String deptWriteSave(DeptVO deptvo) {
		
		System.out.println("부서번호 : " + deptvo.getDeptno());
		System.out.println("부서이름 : " + deptvo.getDname());
		System.out.println("부서위치 : " + deptvo.getLoc());
		return "";
	}
}
