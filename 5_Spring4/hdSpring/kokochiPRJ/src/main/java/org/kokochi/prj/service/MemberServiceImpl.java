package org.kokochi.prj.service;

import java.util.List;

import org.kokochi.prj.domain.Member;
import org.kokochi.prj.domain.MemberAuth;
import org.kokochi.prj.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void register(Member member) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(member);
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_MEMBER");
		mapper.createAuth(memberAuth);
	}

	@Override
	public Member read(int userNo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.read(userNo);
	}

	@Override
	public void modify(Member member) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(member);
		
		int userNo = member.getUserNo();
		mapper.deleteAuth(userNo);
		List<MemberAuth> authList = member.getAuthList();
		
		for(int i=0;i<authList.size();i++) {
			MemberAuth memberAuth = authList.get(i);
			
			String auth = memberAuth.getAuth();
			
			if(auth == null) continue;
			if(auth.trim().length() == 0) continue;
			
			memberAuth.setUserNo(userNo);
			mapper.createAuth(memberAuth);
		}
	}

	@Override
	public void remove(int userNo) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
	}

	@Override
	public List<Member> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int getCoin(int userNo) throws Exception {
		// TODO Auto-generated method stub
		Member member = mapper.read(userNo);
		return member.getCoin();
	}

	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.countAll();
	}
	
	@Transactional
	@Override
	public void setupAdmin(Member member) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_ADMIN");
		mapper.createAuth(memberAuth);
	}
	
	

}
