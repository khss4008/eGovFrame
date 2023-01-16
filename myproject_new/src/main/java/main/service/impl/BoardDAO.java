package main.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import main.service.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO{

	public String insertNBoard(BoardVO vo) {
		return (String)insert("BoardDAO.insertNBoard", vo);
	}

	public List<?> selectNBoardList(BoardVO vo) {
		return list("BoardDAO.selectNBoardList",vo);
	}

	public int selectNBoardTotal(BoardVO vo) {
		return (int)select("BoardDAO.selectNBoardTotal",vo);
	}

	public BoardVO selectNBoardDetail(BoardVO vo) {
		return (BoardVO)select("BoardDAO.selectNBoardDetail", vo);
	}

	public int updateNBoardHits(int unq) {
		return update("BoardDAO.updateNBoardHits",unq);
	}

	public int updateNBoard(BoardVO vo) {
		return update("BoardDAO.updateNBoard", vo);
	}

	public int selectNBoardPass(BoardVO vo) {
		return (int)select("BoardDAO.selectNBoardPass",vo);
	}

}
