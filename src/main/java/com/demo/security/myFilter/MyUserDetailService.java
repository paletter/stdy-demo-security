package com.demo.security.myFilter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Find user from db which username matching
		List<DbUser> userList = new ArrayList<MyUserDetailService.DbUser>();
		
		DbUser u1 = new DbUser();
		u1.userName = "user";
		u1.pwd = "user";
		u1.auth = "user";
		userList.add(u1);
		
		DbUser u2 = new DbUser();
		u2.userName = "admin";
		u2.pwd = "admin";
		u2.auth = "admin";
		userList.add(u2);
		
		DbUser loginUser = null;
		for(DbUser u : userList) {
			if(username.equals(u.userName)) {
				loginUser = u;
			}
		}
		
		if(loginUser != null) {
			
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			
			if(loginUser.auth == "user") {
				authList.add(new GrantedAuthorityImpl("ADMIN"));
			}
			
			if(loginUser.auth == "admin") {
				authList.add(new GrantedAuthorityImpl("USER"));
				authList.add(new GrantedAuthorityImpl("ADMIN"));
			}
			
			// Matching username and pwd
			UserDetails user = new User(loginUser.userName, loginUser.pwd, true, true, true, true, authList);
			
			return user;
		}
		
		return null;
	}
	
	public class DbUser {
		public String userName;
		public String pwd;
		public String auth;
	}
}
