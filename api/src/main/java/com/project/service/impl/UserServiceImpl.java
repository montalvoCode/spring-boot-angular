package com.project.service.impl;

import com.project.bean.Users;
import com.project.mapper.UserMapper;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;


	@Override
	public List<Users> listUsers() {
		return userMapper.listUsers();
	}

	@Override
	public List<Users> listIdUser(Integer idUsers) {
		return userMapper.listIdUser(idUsers);
	}

	@Override
	public void registerUsers(Users users) {
		userMapper.registerUsers(users);
	}

	@Override
	public void updateUsers(Users users) {
		userMapper.updateUsers(users);
	}

	@Override
	public void deleteUsers(Integer idUsers) {
		userMapper.deleteUsers(idUsers);
	}
}
