package com.project.service.impl;

import java.util.Date;
import java.util.List;

import com.project.bean.Users;
import com.project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.mybatis.UserRepository;
import com.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;


	@Override
	public List<Users> listUsers() {
		return userMapper.listUsers();
	}

	@Override
	public List<Users> listTypeUser(String typeUser) {
		return userMapper.listTypeUser(typeUser);
	}

	@Override
	public void registerUsers(Users users) {
		userMapper.registerUsers(users);
	}

	@Override
	public void updateUsers(Users users) {
		userMapper.updateUsers(users);
	}
}
