package org.kokochi.common.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.kokochi.prj.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	private static final long serialVersionUID = 2467724710784811766L;
	private Member member;
	
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public CustomUser(Member member) {
		// TODO Auto-generated constructor stub
		super(member.getUserId(), member.getUserPw(), member.getAuthList().stream().map(
				auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	
	
	
}
