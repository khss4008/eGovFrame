package egovframework.example.sample.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.CodeVO;

@Repository("codeDAO")
public class CodeDAO extends EgovAbstractDAO{

	public String insertCodes(CodeVO vo) {
		return (String)insert("codeDAO.insertCodes", vo);
	}

	public List<?> selectCodeList(CodeVO vo) {
		return list("codeDAO.selectCodeList", vo);
	}

	public int selectCodesCount(CodeVO vo) {
		return (int)select("codeDAO.selectCodesCount",vo);
	}

	public int deleteCode(int code) {
		return delete("codeDAO.deleteCode",code);
	}

	public int updateCode(CodeVO vo) {
		return update("codeDAO.updateCode",vo);
	}

	public CodeVO selectCodeDetail(int code) {
		return (CodeVO)select("codeDAO.selectCodeDetail",code);
	}
	
}
