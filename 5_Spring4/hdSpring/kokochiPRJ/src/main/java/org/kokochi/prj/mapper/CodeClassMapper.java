package org.kokochi.prj.mapper;

import java.util.List;

import org.kokochi.prj.domain.CodeClass;

public interface CodeClassMapper {
	
	public void create(CodeClass codeClass) throws Exception;
	
	public CodeClass read(String classCode) throws Exception;
	
	public void update(CodeClass codeClass) throws Exception;
	
	public void delete(String classCode) throws Exception;
	
	public List<CodeClass> list() throws Exception;

}
