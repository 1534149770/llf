package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao extends FDao<User>{
	User selectUserByUsernamePassword(User user);
}
