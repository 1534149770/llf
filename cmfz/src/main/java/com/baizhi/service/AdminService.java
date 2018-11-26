package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
	Admin findAdminByUsernamePassword(Admin admin);
	void changeAdminPassword(Admin admin);
}
