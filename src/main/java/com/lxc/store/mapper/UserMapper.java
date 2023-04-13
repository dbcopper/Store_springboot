package com.lxc.store.mapper;
//用户模块的接口

import com.lxc.store.entity.User;

public interface UserMapper {
//    插入一个用户对象，return受影响的行数，根据返回值判断是否成功
    Integer insert(User user);
//    找到返回用户的数据，没找到返回null
    User finByUsername(String username);

}
