package com.pactera.sqlanalyzed.dao;

import com.pactera.sqlanalyzed.entity.User;

public interface UserMapper {
	
	User queryById(String id);

}
