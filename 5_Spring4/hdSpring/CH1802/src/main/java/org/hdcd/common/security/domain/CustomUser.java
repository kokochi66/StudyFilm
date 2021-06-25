package org.hdcd.common.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.hdcd.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private Member member;
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public CustomUser(Member member) {
		super(member.getUserId(), member.getUserPw(), member.getAuthList().stream().map(auth-> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	
	
}
