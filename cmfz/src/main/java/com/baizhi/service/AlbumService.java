package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Album;
import com.llf.dto.AlbumDto;

public interface AlbumService {
	void addAlbum(Album album);
	AlbumDto findAllAlbumByPage(int curPage, int pageSize);
	List<Album> findAllAlbum();
	int findAlbumCount(int id);
}
