package com.baizhi.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.llf.dto.AlbumDto;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{

	@Resource(name="albumDao")
	private AlbumDao dao;
	
	@Override
	public void addAlbum(Album album) {
		dao.insertOne(album);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@Override
	public AlbumDto findAllAlbumByPage(int curPage, int pageSize) {
		AlbumDto dto = new AlbumDto();
		dto.setTotal(dao.selectTotalCount());
		dto.setRows(dao.selectAllByPage(curPage, pageSize));
		return dto;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@Override
	public List<Album> findAllAlbum() {
		return dao.selectAll();
	}

	@Override
	public int findAlbumCount(int id) {
		return dao.selectAlbumCount(id);
	}

}
