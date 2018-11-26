package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Album;

public interface AlbumDao extends FDao<Album>{
	int selectAlbumCount(int id);
}
