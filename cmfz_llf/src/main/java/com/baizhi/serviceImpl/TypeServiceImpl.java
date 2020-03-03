package com.baizhi.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.TypeDao;
import com.baizhi.entity.Type;
import com.baizhi.service.TypeService;

@Service("typeService")
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource(name="typeDao")
	private TypeDao dao;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@Override
	public List<Type> findAll() {
		System.out.println("路过TypeServiceImpl中的queryAll");
		System.out.println("集合是否为空"+dao.selectAll()==null);
		return dao.selectAll();
	}

}
