package com.lxc.store.service;

import com.lxc.store.entity.User;
import com.lxc.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*业务层的单元测试*/
/*标注当前的类是一个测试类，不会随着项目一起打包*/

/*表示启动这个单元测试类(单元测试类是不能运行的)，需要传递一个参数，必须是SpringRunner的实例类型*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService IUserService;


    /*
    * 单元测试方法，就可以单独运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
    * 必须被@Test注解修饰，
    * 返回值必须是void
    * 方法的参数列表不指定任何类型
    * 方法的方法修饰修饰符必须是public
    * */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("yuanxin03");
            user.setPassword("123");
            IUserService.reg(user);
            System.out.println("ok");
            /*添加异常捕获*/
        } catch (ServiceException e) {
            // 获取类的对象，再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获得异常具体的描述信息
            System.out.println(e.getMessage());
        }

    }

}
