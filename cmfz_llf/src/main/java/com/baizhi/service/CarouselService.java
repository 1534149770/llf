package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Carousel;
import com.llf.dto.CarouselDto;

public interface CarouselService {
	void addCarousel(Carousel carousel);
	void modifyCarousel(Carousel carousel);
	List<Carousel> findAllCarousel();
	CarouselDto findAllCarouselByPage(int curPage, int pageSize);
	void removeCarousel(int id);
}
