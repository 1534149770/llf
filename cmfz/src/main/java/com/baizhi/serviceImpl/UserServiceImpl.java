package com.baizhi.serviceImpl;

import javax.annotation.Resource;

import com.baizhi.aop.LogAnnotation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao dao;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@Override
	public User findUserByUsernamePassword(User user) {
		return dao.selectUserByUsernamePassword(user);
	}

	@Override
	public void addUser(User user) {
		dao.insertOne(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@LogAnnotation(value = "查询所有用户")
	@Override
	public List<User> findAllUser() {
		return dao.selectAll();
	}

}
