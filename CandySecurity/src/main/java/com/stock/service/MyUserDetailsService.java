package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stock.model.UserPrinciple;
import com.stock.model.Users;
import com.stock.service.dao.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
    private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Users user = repo.findByUsername(username);
System.out.println(user);
if(user==null) {
	System.out.println("user not found");
	throw new UsernameNotFoundException("user 404");
}
	
return new UserPrinciple(user) ;
	}

}
