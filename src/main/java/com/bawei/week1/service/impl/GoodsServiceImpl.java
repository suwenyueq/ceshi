package com.bawei.week1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.week1.dao.GoodsMapper;
import com.bawei.week1.domain.Brand;
import com.bawei.week1.domain.Goods;
import com.bawei.week1.domain.Type;
import com.bawei.week1.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 苏文越
 *
 * 2019年12月30日
 */
@Service
public class GoodsServiceImpl  implements GoodsService{
	@Autowired
	private GoodsMapper goodsMapper;
	public PageInfo<Goods> selects(Goods goods, Integer page, Integer pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,pagesize);
		List<Goods> selects = goodsMapper.selects(goods);
		return new PageInfo<Goods>(selects);
	}
	public List<Type> selectTypes() {
		// TODO Auto-generated method stub
		return goodsMapper.selectTypes();
	}
	public List<Brand> selectBrands() {
		// TODO Auto-generated method stub
		return goodsMapper.selectBrands();
	}
	public int insert(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.insert(goods);
	}

}
