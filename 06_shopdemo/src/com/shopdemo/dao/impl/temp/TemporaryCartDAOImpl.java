package com.shopdemo.dao.impl.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shopdemo.dao.TemporaryCartDAO;
import com.shopdemo.entity.CartDO;

public class TemporaryCartDAOImpl implements TemporaryCartDAO {

	private static Map<String, Map<String, CartDO>> cartList = new HashMap<String, Map<String, CartDO>>();

	@Override
	public void addToCart(String account, CartDO cart) {

		Map<String, CartDO> userCart = cartList.get(account);

		if (userCart == null) {
			userCart = new HashMap<String, CartDO>();
			cartList.put(account, userCart);
			
		}

		if (!userCart.containsKey(cart.getGoodsDO().getId())) {
			userCart.put(cart.getGoodsDO().getId(), cart);

		} else {
			CartDO cartDO = userCart.get(cart.getGoodsDO().getId());
			cartDO.setNumber(cartDO.getNumber() + cart.getNumber());
			cartDO.setTotlePrice(cart.getTotlePrice() + cartDO.getTotlePrice());
			userCart.put(cart.getGoodsDO().getId(), cartDO);
		}

	}

	@Override
	public void removeFromCart(String account, String goodsId) {
		
		 Map<String,CartDO> userCart = cartList.get(account);
		 
	     if(userCart!=null){
	    	 userCart.remove(goodsId);
	     }
	}

	@Override
	public List<CartDO> getAllFromCart(String account) {
		
        List<CartDO> list = new ArrayList<>();
        Map<String,CartDO> userCart = cartList.get(account);
        
        if(userCart!=null){
        	list = new ArrayList<CartDO>(userCart.values());
        }
        return list;
	}

}
