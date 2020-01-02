package com.bawei.week1.dao;

import java.util.List;

import com.bawei.week1.domain.Brand;
import com.bawei.week1.domain.Goods;
import com.bawei.week1.domain.Type;

/**
 * @author 苏文越
 *
 * 2019年12月30日
 */
public interface GoodsMapper {
	List<Goods> selects(Goods goods);

	List<Type> selectTypes();

	List<Brand> selectBrands();

	int insert(Goods goods);
}
