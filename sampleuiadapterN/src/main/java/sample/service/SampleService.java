package sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {
	List<Map<String, Object>> selectSampleList(Map<String, String> searchInfo);


}
