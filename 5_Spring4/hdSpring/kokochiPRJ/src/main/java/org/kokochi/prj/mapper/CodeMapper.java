package org.kokochi.prj.mapper;

import java.util.List;

import org.kokochi.common.domain.CodeLabelValue;

public interface CodeMapper {
	
	public List<CodeLabelValue> getCodeClassList() throws Exception;
	public List<CodeLabelValue> getCodeList(String classCode) throws Exception;
}
