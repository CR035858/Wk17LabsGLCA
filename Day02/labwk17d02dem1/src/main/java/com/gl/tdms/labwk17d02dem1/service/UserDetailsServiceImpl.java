package com.gl.tdms.labwk17d02dem1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.gl.tdms.labwk17d02dem1.entity.User;
import com.gl.tdms.labwk17d02dem1.repository.UserRepository;
import com.gl.tdms.labwk17d02dem1.security.MyUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService {

	   	@Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	        throws UsernameNotFoundException {
	        User user = userRepository.getUserByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	        return new MyUserDetails(user);
	    }

}
