package com.shopdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.shopdemo.dao.BaseDAO;
import com.shopdemo.entity.UserDO;

public interface UserDAO extends BaseDAO{
	/**
	 * 获得系统中的所有用户
	 * @return
	 */
	public List<UserDO> getAll() throws SQLException;
	/**
	 * 用于登录校验
	 * @param account
	 * @param password
	 * @return
	 */
	public UserDO findUser(String account, String password) throws SQLException;
	/**
	 * 在系统中创建一个用户的信息
	 * @param user
	 * @return
	 */
	public int insertUser(UserDO user) throws SQLException;
	/**
	 * 根据用户的id删除一个用户
	 * @param id
	 * @return
	 */
	public int deleteUser(String id) throws SQLException;
	/**
	 * 根据用户名获取一个用户的基本信息
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public UserDO getUserByAccount(String account) throws SQLException;

}
