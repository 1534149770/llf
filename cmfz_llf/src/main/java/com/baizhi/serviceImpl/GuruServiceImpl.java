package com.baizhi.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.llf.dto.GuruDto;

@Service("guruService")
@Transactional
public class GuruServiceImpl implements GuruService {

	@Resource(name="guruDao")
	private GuruDao dao;
	
	@Override
	public void addGuru(Guru guru) {
		dao.insertOne(guru);
	}

	@Override
	public void modifyGuru(Guru guru) {
		dao.updateOne(guru);
	}

	@Override
	public List<Guru> findAllGuru() {
		return dao.selectAll();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@Override
	public GuruDto findAllGuruByPage(int curPage, int pageSize) {
		GuruDto dto = new GuruDto();
		dto.setTotal(dao.selectTotalCount());
		dto.setRows(dao.selectAllByPage(curPage, pageSize));
		return dto;
	}

	@Override
	public void removeGuru(int id) {
		dao.deleteOne(id);
	}

}
