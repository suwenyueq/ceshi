package com.bawei.week1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.week1.domain.Brand;
import com.bawei.week1.domain.Goods;
import com.bawei.week1.domain.Type;
import com.bawei.week1.service.GoodsService;
import com.github.pagehelper.PageInfo;


/**
 * @author 苏文越
 *
 *         2019年12月30日
 */
@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("goods")
	public String goods(Model model, Goods goods, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		PageInfo<Goods> info = goodsService.selects(goods, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("goods", goods);
		return "good";
	}

	@GetMapping("add")
	public String add() {
		return "add";
	}
	@ResponseBody
	@PostMapping("add")
	public boolean add(Goods goods,MultipartFile file) throws IllegalStateException, IOException{
		if (null!=file&& !file.isEmpty()) {
			String path="d:/week1/";
			String oldFilename = file.getOriginalFilename();
			String fileName=UUID.randomUUID()+oldFilename.substring(oldFilename.lastIndexOf("."));
			File f = new File(path,fileName);
			file.transferTo(f);
			goods.setPic(fileName);
		}
		return goodsService.insert(goods)>0;
	}

	// 类型
	@ResponseBody
	@GetMapping("selectTypes")
	public List<Type> selectTypes() {
		return goodsService.selectTypes();
	}

	/// 品牌
	@ResponseBody
	@GetMapping("selectBrands")
	public List<Brand> selectBrands() {
		return goodsService.selectBrands();
	}
}
