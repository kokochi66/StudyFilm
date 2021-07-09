package org.kokochi.common.security;

import org.kokochi.common.security.domain.CustomUser;
import org.kokochi.prj.domain.Member;
import org.kokochi.prj.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Member member = memberMapper.readByUserId(username);
		
		return member == null ? null : new CustomUser(member);
	}

}
