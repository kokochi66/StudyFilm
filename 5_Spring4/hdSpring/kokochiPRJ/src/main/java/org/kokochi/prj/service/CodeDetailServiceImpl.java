package org.kokochi.prj.service;

import java.util.List;

import org.kokochi.prj.domain.CodeDetail;
import org.kokochi.prj.mapper.CodeDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeDetailServiceImpl implements CodeDetailService {

	@Autowired
	private CodeDetailMapper mapper;
	
	@Override
	public void register(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		String classCode = codeDetail.getClassCode();
		int maxSortSeq = mapper.getMaxSortSeq(classCode);
		
		codeDetail.setSortSeq(maxSortSeq + 1);
		
		mapper.create(codeDetail);
	}

	@Override
	public CodeDetail read(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service read = " + codeDetail.toString());
		return mapper.read(codeDetail);
	}

	@Override
	public void modify(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(codeDetail);
	}

	@Override
	public void remove(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(codeDetail);
	}

	@Override
	public List<CodeDetail> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

}
