package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.BoardService;
import main.service.BoardVO;

@Controller
public class BoardController {
	
	@Resource(name = "boardService")
	BoardService boardService;
	
	@RequestMapping("/boardWrite.do")
	public String boardWrite() throws Exception{
		
		return "board/boardWrite";
	}
	
	@RequestMapping("/boardWriteSave.do")
	@ResponseBody
	public String insertBoard(BoardVO vo) throws Exception {
		
		//구현체를 찾아야 하는데 그 때 위의 어노테이션에 적힌 name을 통해서 찾는 것.
		String result = boardService.insertNBoard(vo);
		String msg = "";
		if(result == null) msg = "ok";
		else msg = "fail";
		
		return msg;
	}
	
	@RequestMapping("/boardList.do")
	public String selectNBoardList(BoardVO vo, ModelMap model) throws Exception{
		
		List<?> result = boardService.selectNBoardList(vo);
		model.addAttribute("resultList",result);
		
		
		return "board/boardList";
	}
}
