package org.kokochi.prj.service;

import java.util.List;

import org.kokochi.prj.domain.CodeClass;
import org.kokochi.prj.mapper.CodeClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeClassServiceImpl implements CodeClassService {

	@Autowired
	private CodeClassMapper mapper;
	
	@Override
	public void register(CodeClass codeClass) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(codeClass);
	}

	@Override
	public CodeClass read(String classCode) throws Exception {
		// TODO Auto-generated method stub
		return mapper.read(classCode);
	}

	@Override
	public void modify(CodeClass codeClass) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(codeClass );
	}

	@Override
	public void remove(String classCode) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(classCode);
	}

	@Override
	public List<CodeClass> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

}
