package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao extends FDao<Admin>{
	Admin selectAdminByUsernamePassword(Admin admin);
}
