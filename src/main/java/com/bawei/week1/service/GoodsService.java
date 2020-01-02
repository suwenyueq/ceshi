package com.bawei.week1.service;

import java.util.List;

import com.bawei.week1.domain.Brand;
import com.bawei.week1.domain.Goods;
import com.bawei.week1.domain.Type;
import com.github.pagehelper.PageInfo;

/**
 * @author 苏文越
 *
 * 2019年12月30日
 */

public interface GoodsService {
	PageInfo<Goods> selects(Goods goods,Integer page,Integer pagesize);

	List<Type> selectTypes();

	List<Brand> selectBrands();

	int insert(Goods goods); 
}
