package main.service;

import java.util.List;

public interface MemberService {
	//회원가입
	public String insertMember(MemberVO vo) throws Exception; 
	//id 체크
	public int idCheck(String userId) throws Exception;
	//우편번호 주소 검색
	public List<?> selectPostList(String dong) throws Exception;
	//로그인데이터 확인
	public int selectMemberCount(MemberVO vo) throws Exception;
	
}
