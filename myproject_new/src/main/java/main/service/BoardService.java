package main.service;

import java.util.List;

public interface BoardService {
	//일반게시판 저장처리
	public String insertNBoard(BoardVO vo) throws Exception;
	//일반게시판 화면목록
	List<?> selectNBoardList(BoardVO vo) throws Exception;
	//Total 개수 얻기
	public int selectNBoardTotal(BoardVO vo)throws Exception;
	//상세화면
	public BoardVO selectNBoardDetail(BoardVO vo) throws Exception;
	//조회수 증가
	public int updateNBoardHits(int unq) throws Exception;
	//보드 수정
	public int updateNBoard(BoardVO vo) throws Exception;
	
	public int selectNBoardPass(BoardVO vo)throws Exception;
}
