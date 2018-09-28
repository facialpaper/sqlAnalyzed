package com.pactera.sqlanalyzed.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.sqlanalyzed.dao.UserMapper;
import com.pactera.sqlanalyzed.entity.User;
import com.pactera.sqlanalyzed.service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserByUserId(String id) {
		
		User user = userMapper.queryById(id);
       
		return user;  
	}

}
