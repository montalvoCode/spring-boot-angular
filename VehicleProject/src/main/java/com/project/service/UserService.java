package com.project.service;

import com.project.bean.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<Users> listUsers();

    List<Users> listTypeUser(String typeUser);

    void registerUsers(Users users);

    void updateUsers(Users users);

}
