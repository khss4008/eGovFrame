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

}
