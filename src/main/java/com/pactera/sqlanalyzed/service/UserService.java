package com.pactera.sqlanalyzed.service;

import com.pactera.sqlanalyzed.entity.User;

public interface UserService {

	User getUserByUserId(String id);
}
