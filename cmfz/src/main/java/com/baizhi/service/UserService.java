package com.baizhi.service;


import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
	User findUserByUsernamePassword(User user);
	void addUser(User user);
	List<User> findAllUser();
}
