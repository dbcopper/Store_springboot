package com.lxc.store.service;

import com.lxc.store.entity.User;

/*用户模块业务层接口*/
/*业务层不需要返回值*/
public interface IUserService {
    /*用户注册方法，用户的数据对象*/
    void reg(User user);
}
