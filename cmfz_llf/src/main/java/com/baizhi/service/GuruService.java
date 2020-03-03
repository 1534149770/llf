package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Guru;
import com.llf.dto.GuruDto;

public interface GuruService {
	void addGuru(Guru Guru);
	void modifyGuru(Guru Guru);
	List<Guru> findAllGuru();
	GuruDto findAllGuruByPage(int curPage, int pageSize);
	void removeGuru(int id);
}
