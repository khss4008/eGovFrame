package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;
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
	public String insertBoard(BoardVO vo) throws Exception{
		String msg = "";
			String result = boardService.insertNBoard(vo);
			if(result == null) msg = "ok";
			else msg = "fail";

		
		return msg;
	}
	
	@RequestMapping("/boardList.do")
	public String selectNBoardList(BoardVO vo, ModelMap model) throws Exception{
			
			int total = boardService.selectNBoardTotal(vo);
			int unit = 10;
			// 12/10 -> ceil(1.2) -> Integer(2.0) -> 2
			int totalPage = (int) Math.ceil((double)total/unit);
			
			int viewPage = vo.getViewPage();
			
			if(viewPage > totalPage || viewPage < 1) {
				viewPage = 1;
			}
			
			//1-> 1, 10 // 2-> 11, 20 // 3-> 21, 30
			int startIndex = (viewPage -1)*unit + 1;
			int endIndex = startIndex + (unit-1);
			
			//1page를 보는 상황이라면
			//total 28
			//1page -> 28 ~ 19 , 2 -> 18 ~ 9 , 3 -> 8 ~ 1
			int startRowNo = total - (viewPage -1)*unit;
			
			vo.setStartIndex(startIndex);
			vo.setEndIndex(endIndex);
			
			
			
			List<?> result = boardService.selectNBoardList(vo);
			model.addAttribute("rowNumber", startRowNo);
			model.addAttribute("total", total);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("resultList",result);
		
		return "board/boardList";
	}
	
	@RequestMapping("boardDetail.do")
	public String boardDetail(BoardVO vo, ModelMap model) throws Exception{
		
		//조회수 증가
		boardService.updateNBoardHits(vo.getUnq());
		
		BoardVO data = boardService.selectNBoardDetail(vo);
		String content =data.getContent();
		data.setContent(content.replace("\n", "<br>"));
		
		model.addAttribute("data",data);
		return "board/boardDetail";
	}
	@RequestMapping("boardModifyWrite.do")
	public String boardModifyWrite(BoardVO vo, ModelMap model) throws Exception{
		
		BoardVO boardVO = boardService.selectNBoardDetail(vo);
		System.out.println( "콘텐츠 값 " + boardVO.getContent());
		model.addAttribute("boardVO",boardVO);

		return "board/boardModifyWrite";
	}
	@RequestMapping("boardModifySave.do")
	@ResponseBody
	public String boardModifySave(BoardVO vo) throws Exception{

		int result = 0;
		int count =boardService.selectNBoardPass(vo);
		if(count == 1) {
			result = boardService.updateNBoard(vo);	//int result = 1;		
		}else {
			result = -1;
		}
		
		return result+"";
	}
	
}
