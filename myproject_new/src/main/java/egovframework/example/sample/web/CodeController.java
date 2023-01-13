package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;

@Controller
public class CodeController {
	
	@Resource(name="codeService")
	private CodeService codeService;
	
	@RequestMapping(value = "codeWrite.do")
	public String codeWrite() {
		
		return "code/codeWrite";
	}
	
	@RequestMapping(value = "codeWriteSave.do")
	public String insertCode(CodeVO vo) throws Exception{
		
		//String result = null; <- 이게 성공한거임
		String result = codeService.insertCodes(vo);
		if(result == null) System.out.println("삽입 성공");
		else System.out.println("삽입 실패");//사실 insert가 실패하면 exception을 뱉기 때문에 필요가 없음
		return "redirect:codeList.do";
	}

	@RequestMapping(value = "codeList.do")
	public String selectCodeList(CodeVO vo, ModelMap model) throws Exception{
		
		//String result = null; <- 이게 성공한거임
		List<?> result = codeService.selectCodeList(vo);
		model.addAttribute("resultList",result);
		
		int total = codeService.selectCodesCount(vo);
		model.addAttribute("resultTotal", total);
		return "code/codeList";
	}
	
	@RequestMapping(value="codeDelete.do")
	public String codeDelete(int code) throws Exception{
		System.out.println("잘 들어갔나?"+code);
		int no = codeService.deleteCode(code);
		if(no == 1) System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
		return "redirect:codeList.do";
	}
	
	
	@RequestMapping(value = "/codeUpdate.do")
	public String updateCode(int code, ModelMap model) throws Exception{
		
		CodeVO result = codeService.selectCodeDetail(code);
		model.addAttribute("resultDetail",result);
		return "code/codeUpdate";
	}
	
	@RequestMapping(value ="/codeUpdateSave.do")
	public String updateSave(CodeVO vo)throws Exception{
		
		codeService.updateCode(vo);
		
		return "redirect:codeList.do";
	}
	
}
