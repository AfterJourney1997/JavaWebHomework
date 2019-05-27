package com.shopdemo.dao.impl.temp;

import java.util.HashMap;
import java.util.Map;

import com.shopdemo.dao.TemporaryCartDAO;
import com.shopdemo.entity.CartDO;

/*public class TemporaryCartDAOImpl implements TemporaryCartDAO {

	private static Map<String,Map<String,CartDO>> cartList = new HashMap<String,Map<String,CartDO>>();
	
    @Override
    public void addToCart(String account, CartDO auctionDO) {
        Map<String,CartDO> userCart = cartList.get(username);
        if(userCart==null){
            userCart = new HashMap<String, CartDO>();
            cartList.put(username,userCart);
        }
        if(!userCart.containsKey(auctionDO.getId())){
            userCart.put(auctionDO.getId(),new CartDO());
        }
        CartDO cart = userCart.get(auctionDO.getId());
        cart.setAuctionDO(auctionDO);
        cart.setNumber(cart.getNumber()+1);
        cart.setTotlePrice(cart.getTotlePrice()+auctionDO.getPrice());
    }
	
}*/
