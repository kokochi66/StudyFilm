package org.hdcd.common.security;

import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.Member;
import org.hdcd.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class customUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(customUserDetailsService.class);
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.warn("Load User By UserNmae = " + username);
		
		Member member = memberMapper.read(username);
		
		logger.warn("queried by member mapper = " + member);
		return member == null ? null : new CustomUser(member);
	}

}
