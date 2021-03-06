package com.shopdemo.entity;

public class CartDO {

    private GoodsDO goodsDO;
    private double totlePrice;
    private int number;
	
    public CartDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDO(GoodsDO goodsDO, double totlePrice, int number) {
		super();
		this.goodsDO = goodsDO;
		this.totlePrice = totlePrice;
		this.number = number;
	}

	public GoodsDO getGoodsDO() {
		return goodsDO;
	}

	public void setGoodsDO(GoodsDO goodsDO) {
		this.goodsDO = goodsDO;
	}

	public double getTotlePrice() {
		return totlePrice;
	}

	public void setTotlePrice(double totlePrice) {
		this.totlePrice = totlePrice;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CartDO [goodsDO=" + goodsDO + ", totlePrice=" + totlePrice + ", number=" + number + "]";
	}
    
}
