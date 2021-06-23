package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Member;
import org.hdcd.domain.MemberAuth;
import org.hdcd.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Transactional
	@Override
	public void register(Member member) throws Exception {
		mapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();

		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");

		mapper.createAuth(memberAuth);
	}

	@Override
	public Member read(int userNo) throws Exception {
		return mapper.read(userNo);
	}

	@Transactional
	@Override
	public void modify(Member member) throws Exception {
		mapper.update(member);

		int userNo = member.getUserNo();

		mapper.deleteAuth(userNo);

		String auth = member.getAuth();

		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(userNo);

		if (auth != null) {
			memberAuth.setAuth(auth);
		} else {
			memberAuth.setAuth("ROLE_USER");
		}

		mapper.createAuth(memberAuth);
	}

	@Transactional
	@Override
	public void remove(int userNo) throws Exception {
		mapper.deleteAuth(userNo);

		mapper.delete(userNo);
	}

	@Override
	public List<Member> list() throws Exception {
		return mapper.list();
	}

}
