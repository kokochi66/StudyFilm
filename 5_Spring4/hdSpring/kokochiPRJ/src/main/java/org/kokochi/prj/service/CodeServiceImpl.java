package org.kokochi.prj.service;

import java.util.List;

import org.kokochi.common.domain.CodeLabelValue;
import org.kokochi.prj.mapper.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	private CodeMapper mapper;
	
	@Override
	public List<CodeLabelValue> getCodeClassList() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getCodeClassList();
	}

	@Override
	public List<CodeLabelValue> getCodeList(String classCode) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getCodeList(classCode);
	}

}
