package com.spring.utils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.spring.dto.UserDto;


public class CommonUtil implements Serializable	 {
	
	public static List<SimpleGrantedAuthority> getAuthority(String role) {
		return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    public static UserDto getUserDetailsFromSecurity() {
        return (UserDto) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

}
