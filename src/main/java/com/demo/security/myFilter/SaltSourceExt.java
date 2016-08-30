package com.demo.security.myFilter;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

public class SaltSourceExt implements SaltSource {

	@Override
	public Object getSalt(UserDetails user) {
		String salt = "xqydib";
		return salt; 
	}
	
}
