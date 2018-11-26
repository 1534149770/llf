package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FDao<T> {
	Integer selectTotalCount();
	List<T> selectAllByPage(@Param("curPage") int curPage, @Param("pageSize") int pageSize);
	List<T> selectAll();
	void insertOne(T t);
	void updateOne(T t);
	void deleteOne(int id);
}
