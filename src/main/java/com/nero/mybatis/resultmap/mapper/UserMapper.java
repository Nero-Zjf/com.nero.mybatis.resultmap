package com.nero.mybatis.resultmap.mapper;

import com.nero.mybatis.resultmap.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(Long id);

    List<Map<String,Object>> getAllUser();
    List<User> getAllUser2();
    List<User> getAllUser3();
}
