package org.kokochi.prj.service;

import java.util.List;

import org.kokochi.common.domain.CodeLabelValue;

public interface CodeService {
	
	public List<CodeLabelValue> getCodeClassList() throws Exception;
	
	public List<CodeLabelValue> getCodeList(String classCode) throws Exception;

}
