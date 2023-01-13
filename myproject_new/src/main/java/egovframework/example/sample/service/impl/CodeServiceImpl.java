package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;

@Service("codeService")
public class CodeServiceImpl implements CodeService {

	@Resource(name = "codeDAO")
	CodeDAO codeDAO;
	
	@Override
	public String insertCodes(CodeVO vo) throws Exception {
		return codeDAO.insertCodes(vo);
	}

	@Override
	public List<?> selectCodeList(CodeVO vo) throws Exception {
		return codeDAO.selectCodeList(vo);
	}

	@Override
	public int selectCodesCount(CodeVO vo) throws Exception {
		return codeDAO.selectCodesCount(vo);
	}

	@Override
	public int deleteCode(int code) throws Exception {
		return codeDAO.deleteCode(code);
	}
	
	@Override
	public CodeVO selectCodeDetail(int code) throws Exception {
		return codeDAO.selectCodeDetail(code);
	}

	@Override
	public int updateCode(CodeVO vo) throws Exception {
		return codeDAO.updateCode(vo);
	}

}
