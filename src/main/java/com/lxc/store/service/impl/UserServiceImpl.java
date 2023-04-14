package com.lxc.store.service.impl;

import com.lxc.store.entity.User;
import com.lxc.store.mapper.UserMapper;
import com.lxc.store.service.IUserService;
import com.lxc.store.service.ex.InsertException;
import com.lxc.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/*y哦那个胡模块业务层的实现类*/
@Service //将当前类的对象交给spring管理，自动创建对象以及对象的维护
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        // 通过user参数来获取传递过来的username
        String username = user.getUsername();
        // 调用findByUserName，判断用户是否被注册过
        User result = userMapper.findByUsername(username);
        // 判断结果集是否为null，不为null抛出用户名被占用的异常
        if(result != null){
            //抛出异常
            throw new UsernameDuplicatedException("用户名被占用");
        }
        // 密码加密处理的实现；md5算法的形式
        // 串+password+串 交给md5进行加密，串：盐值，本身也为一个随机的字符串
        // 将整体进行三次md5加密,忽略原有密码强度提升了数据的安全性
        String oldPassword = user.getPassword();
        // 获取盐值（随机生成）
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 补全数据，盐值的记录
        user.setSalt(salt);
        // 将密码和盐值进行md5加密
        String md5Password = getMD5Password(oldPassword,salt);
        // 将加密后的密码重新补全设置到user中
        user.setPassword(md5Password);
        // 补全数据，is_delete设置成0
        user.setIsDelete(0);

        // 日志信息
        user.setCreatedUser(username);
        user.setModifiedUser(username);
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        // 执行注册业务功能实现(rows==1)
        Integer rows = userMapper.insert(user);
        if (rows!= 1){
            throw new InsertException("在用户注册过程中产生了未知的异常");

        }
    }
    /*定义一个md5算法的加密处理*/
    private String getMD5Password(String password, String salt){
        for (int i = 0; i < 3; i++) {
            /*md5加密方法*/
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
