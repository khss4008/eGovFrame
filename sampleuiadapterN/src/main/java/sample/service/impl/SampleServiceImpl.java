package sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sample.service.SampleService;

@Service("sampleService")
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService{

	private Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
	
	@Resource(name = "sampleMapper")
	private SampleMapper sampleMapper;
	
	@Override
	public List<Map<String, Object>> selectSampleList(Map<String, String> searchInfo) {
		return sampleMapper.selectSampleList(searchInfo);
	}
	
}
