package com.shopdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.shopdemo.entity.GoodsDO;

public interface GoodsDAO extends BaseDAO {

	/**
	 * 从数据源中获取指定id对应的商品信息
	 * @param id
	 * @return
	 */
    public GoodsDO getGoodsById(String id) throws SQLException;
    /**
	 * 从数据源中获取指定name对应的商品信息
	 * @param name
	 * @return
	 */
    public GoodsDO getGoodsByName(String name) throws SQLException;
    /**
     * 添加一条商品信息到数据源中
     * @param auc：要添加的商品对象
     */
    public void addGoods(GoodsDO goods) throws SQLException;
    /**
     * 获取数据源中的全部的商品列表
     * @return
     */
    public List<GoodsDO> getAll() throws SQLException;
    /**
     * 通过商品id删除一条商品记录
     * @param id：要删除的商品的id
     */
    public void deleteGoods(String id) throws SQLException;
    /**
     * 修改数据源中的指定商品信息
     * @param auc:要修改的商品和其修改后的信息
     */
    public void updateGoods(GoodsDO goods) throws SQLException;
    
    // 用于测试连表查询
    public void getGoodsAndCategory(String id) throws SQLException;
	
}
