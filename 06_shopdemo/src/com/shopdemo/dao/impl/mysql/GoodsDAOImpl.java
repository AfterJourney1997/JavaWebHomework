package com.shopdemo.dao.impl.mysql;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.shopdemo.dao.GoodsDAO;
import com.shopdemo.entity.GoodsDO;
import com.shopdemo.util.dbcp.DBCP;

public class GoodsDAOImpl implements GoodsDAO{
	

	@Override
	public GoodsDO getGoodsById(String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBCP.getDataSource());
		String sql = "select * from goods where id = ?";
		GoodsDO goodsDO = queryRunner.query(sql, new BeanHandler<GoodsDO>(GoodsDO.class), id);
		return goodsDO;
	}

	@Override
	public GoodsDO getGoodsByName(String name) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBCP.getDataSource());
		String sql = "select * from goods where name = ?";
		GoodsDO goodsDO = queryRunner.query(sql, new BeanHandler<GoodsDO>(GoodsDO.class), name);
		return goodsDO;
	}

	@Override
	public void addGoods(GoodsDO goods) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBCP.getDataSource());
		String sql = "insert into goods values(?,?,?,?,?)";
		Object[] params = new Object[] {
				goods.getId(),
				goods.getName(),
				goods.getPrice(),
				goods.getDescription(),
				goods.getCategory()
		};
		queryRunner.update(sql, params);
	}

	@Override
	public List<GoodsDO> getAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBCP.getDataSource());
		String sql = "select * from goods";
		List<GoodsDO> list = queryRunner.query(sql, new BeanListHandler<GoodsDO>(GoodsDO.class));
		return list;
	}

	@Override
	public void deleteGoods(String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBCP.getDataSource());
		String sql = "delete form goods where id = ?";
		queryRunner.update(sql, id);
	}

	@Override
	public void updateGoods(GoodsDO goods) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBCP.getDataSource());
		String sql = "update goods set name = ?, price = ?, description = ? where id = ?";
		Object[] params = new Object[] {
			goods.getName(),
			goods.getPrice(),
			goods.getDescription(),
			goods.getId()
		};
		queryRunner.update(sql, params);
	}

	@Override
	public void getGoodsAndCategory(String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBCP.getDataSource());
		String sql = "SELECT * FROM goods, category WHERE goods.id = ? AND goods.category = category.id";
		List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(), id);
		
		for(Map<String, Object> mapValue : list) {
			Set<Entry<String, Object>> set = mapValue.entrySet();
			for(Entry<String, Object> entry : set) {
				System.out.println(entry.getKey() + "：" + entry.getValue());
			}
		}
	}

}
