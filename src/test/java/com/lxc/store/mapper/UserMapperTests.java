package com.lxc.store.mapper;

import com.lxc.store.entity.User;
import com.lxc.store.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*标注当前的类是一个测试类，不会随着项目一起打包*/

/*表示启动这个单元测试类(单元测试类是不能运行的)，需要传递一个参数，必须是SpringRunner的实例类型*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;


    /*
    * 单元测试方法，就可以单独运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
    * 必须被@Test注解修饰，
    * 返回值必须是void
    * 方法的参数列表不指定任何类型
    * 方法的方法修饰修饰符必须是public
    * */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
}
