package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import main.service.BoardService;
import main.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService{

	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public String insertNBoard(BoardVO vo) throws Exception {
		return boardDAO.insertNBoard(vo);
	}

	@Override
	public List<?> selectNBoardList(BoardVO vo) throws Exception {
		return boardDAO.selectNBoardList(vo);
	}

	@Override
	public int selectNBoardTotal(BoardVO vo) throws Exception {
		return boardDAO.selectNBoardTotal(vo);
	}

	@Override
	public BoardVO selectNBoardDetail(BoardVO vo) throws Exception {
		return boardDAO.selectNBoardDetail(vo);
	}

	@Override
	public int updateNBoardHits(int unq) throws Exception {
		return boardDAO.updateNBoardHits(unq);
	}

	@Override
	public int updateNBoard(BoardVO vo) throws Exception {
		return boardDAO.updateNBoard(vo);
	}

	@Override
	public int selectNBoardPass(BoardVO vo) throws Exception {
		return boardDAO.selectNBoardPass(vo);
	}

	
}
