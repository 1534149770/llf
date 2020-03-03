package com.baizhi.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;

@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {

	@Resource(name="chapterDao")
	private ChapterDao dao;
	
	@Override
	public void addChapter(Chapter chapter) {
		dao.insertOne(chapter);
	}

}
