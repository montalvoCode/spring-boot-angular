package com.project.mapper;

import com.project.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    List<Users> listUsers();

    List<Users> listIdUser(@Param("idUsers") Integer idUsers);

    void registerUsers(Users users);

    void updateUsers(Users users);

    void deleteUsers(@Param("idUsers") Integer idUsers);

}
