package com.shopdemo.dao.impl.temp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shopdemo.dao.UserDAO;
import com.shopdemo.entity.UserDO;

public class UserDAOImpl implements UserDAO {

	private static Map<String, UserDO> userList = new HashMap<String, UserDO>();

	static {

		for (int i = 1; i <= 5; i++) {
			UserDO user = new UserDO("admin" + i, "admin" + i, System.currentTimeMillis());
			userList.put("admin" + i, user);
		}

	}

	@Override
	public List<UserDO> getAll() {
		return new ArrayList<UserDO>(userList.values());
	}

	@Override
	public UserDO findUser(String account, String password) {
		Collection<UserDO> collection = userList.values();
		for (UserDO user : collection) {
			if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public int insertUser(UserDO user) {
		userList.put(user.getAccount(), user);
		return 1;
	}

	@Override
	public int deleteUser(String account) {
		userList.remove(account);
		return 1;
	}

	@Override
	public UserDO getUserByAccount(String account) {
		return userList.get(account);
	}
}
