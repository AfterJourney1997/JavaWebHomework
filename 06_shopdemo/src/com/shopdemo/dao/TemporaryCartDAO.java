package com.shopdemo.dao;

import java.util.List;

import com.shopdemo.entity.CartDO;

public interface TemporaryCartDAO extends BaseDAO {

	/**
	 * 添加商品到临时购物车中
	 * 
	 * @param auctionDO
	 */
	public void addToCart(String account, CartDO cart);

	/**
	 * 从临时购物车中删除一条商品记录
	 * 
	 * @param aucId
	 */
	public void removeFromCart(String account, String goodsId);

	/**
	 * 从临时购物车中将所有的商品信息获取出来
	 * 
	 * @return
	 */
	public List<CartDO> getAllFromCart(String account);

}
