package com.baizhi.serviceImpl;

import javax.annotation.Resource;

import com.baizhi.aop.LogAnnotation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Resource(name="adminDao")
	private AdminDao dao;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@LogAnnotation(value = "登录")
	@Override
	public Admin findAdminByUsernamePassword(Admin admin) {
		return dao.selectAdminByUsernamePassword(admin);
	}

	@Override
	public void changeAdminPassword(Admin admin) {
		dao.updateOne(admin);
	}

}
