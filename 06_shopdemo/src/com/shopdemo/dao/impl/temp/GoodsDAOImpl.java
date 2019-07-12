package com.shopdemo.dao.impl.temp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shopdemo.dao.GoodsDAO;
import com.shopdemo.entity.GoodsDO;

public class GoodsDAOImpl implements GoodsDAO{
	
	private static Map<String,GoodsDO> goodsList = new HashMap<>();

	// 生成20个商品
	static{
		for(int i=0;i<20;i++){
			GoodsDO goods = new GoodsDO("商品"+(i+1), 100+(int)(Math.random()*100), "description"+(i+1), 1);
			goodsList.put(goods.getId(), goods);
		}
	}
	
	@Override
	public GoodsDO getGoodsById(String id) {
		return goodsList.get(id);
	}
	
	@Override
	public GoodsDO getGoodsByName(String name) {
		
		for(GoodsDO goods : goodsList.values()) {
			if(name.equals(goods.getName())) {
				return goods;
			}
		}
		return null;
	}

	@Override
	public void addGoods(GoodsDO goods) {
		goodsList.put(goods.getId(), goods);
	}

	@Override
	public List<GoodsDO> getAll() {
		return new ArrayList<GoodsDO>(goodsList.values());
	}

	@Override
	public void deleteGoods(String id) {
		goodsList.remove(id);
	}

	@Override
	public void updateGoods(GoodsDO goods) {
		goodsList.put(goods.getId(), goods);
	}

	@Override
	public void getGoodsAndCategory(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
