package com.baizhi.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import com.baizhi.aop.LogAnnotation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import com.llf.dto.CarouselDto;

@Service("carouselService")
@Transactional
public class CarouselServiceImpl implements CarouselService {

	@Resource(name="carouselDao")
	private CarouselDao dao;

	@LogAnnotation(value = "添加轮播图")
	@Override
	public void addCarousel(Carousel carousel) {
		dao.insertOne(carousel);
	}

	@LogAnnotation(value = "修改轮播图")
	@Override
	public void modifyCarousel(Carousel carousel) {
		dao.updateOne(carousel);
	}

	@Override
	public List<Carousel> findAllCarousel() {
		return dao.selectAll();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@Override
	public CarouselDto findAllCarouselByPage(int curPage, int pageSize) {
		CarouselDto dto = new CarouselDto();
		dto.setTotal(dao.selectTotalCount());
		dto.setRows(dao.selectAllByPage(curPage, pageSize));
		return dto;
	}

	@LogAnnotation(value = "删除轮播图")
	@Override
	public void removeCarousel(int id) {
		dao.deleteOne(id);
	}

}
