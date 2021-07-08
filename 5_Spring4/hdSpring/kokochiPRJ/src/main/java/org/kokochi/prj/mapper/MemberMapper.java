package org.kokochi.prj.mapper;

import java.util.List;

import org.kokochi.prj.domain.Member;
import org.kokochi.prj.domain.MemberAuth;

public interface MemberMapper {
	
	public Member readByUserId(String userId);
	public void create(Member member) throws Exception;
	public Member read(int userNo) throws Exception;
	public void update(Member member) throws Exception;
	public void delete(int userNo) throws Exception;
	public List<Member> list() throws Exception;
	public void createAuth(MemberAuth memberAuth) throws Exception;
	public void deleteAuth(int userNo) throws Exception;
	public int countAll() throws Exception;

}
