package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {
	
	@Resource(name = "deptService")
	private DeptService deptService;
	
	@RequestMapping(value = "/deptWrite.do")
	public String deptWrite() {
		
		return "dept/deptWrite";
	}

	@RequestMapping(value = "/deptWriteSave.do")
	public String insertDept(DeptVO vo) throws Exception {
		
		System.out.println(vo.getDeptno());
		System.out.println(vo.getDname());
		System.out.println(vo.getLoc());
		
		String result = deptService.insertDept(vo);
		
		if(result == null) { // ok
			System.out.println("저장 완료");
		}else {
			System.out.println("저장 실패");
		}
		
		return "";
	}
	
	@RequestMapping(value = "/deptList.do")
	public String selectDeptList(DeptVO vo, ModelMap model) throws Exception{
		
		List<?> list = deptService.selectDeptList(vo);
		model.addAttribute("resultList", list);
		
		return "dept/deptList";
	}
	@RequestMapping(value = "/deptDetail.do")
	public String selectDeptDetail(int deptno, ModelMap model) throws Exception{
		
		DeptVO vo = deptService.selectDeptDetail(deptno);
		model.addAttribute("deptVO", vo);
		
		return "dept/deptDetail";
	}
	
	@RequestMapping(value = "/deptDelete.do")
	public String deptDelete(int deptno) throws Exception{
		System.out.println("잘 들어갔나?"+deptno);
		int no = deptService.deleteDept(deptno);
		if(no == 1) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		return "";
	}
	
	@RequestMapping(value = "/deptModifyWrite.do")
	public String selectDeptModify(int deptno, ModelMap model) throws Exception{
		
		
		DeptVO vo = deptService.selectDeptDetail(deptno);
		model.addAttribute("vo", vo);
		
		return "dept/deptModifyWrite";
	}
	
	@RequestMapping(value = "/deptModifySave.do")
	public String updateDept(DeptVO vo) throws Exception{
		
		int no = deptService.updateDept(vo);
		
		if(no == 1) System.out.println("변경 완료");
		else System.out.println("변경 실패");
		return "";
	}
	
}
