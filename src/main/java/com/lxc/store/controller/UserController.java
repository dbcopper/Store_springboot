package com.lxc.store.controller;

import com.lxc.store.entity.User;
import com.lxc.store.service.IUserService;
import com.lxc.store.service.ex.InsertException;
import com.lxc.store.service.ex.UsernameDuplicatedException;
import com.lxc.store.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*将这个类交给spring进行管理*/
//@Controller
@RestController // =@Controller+@ResponseBody
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;
    @RequestMapping("reg")
    //@ResponseBody//响应结果以json格式进行，给到前端
    /*Void 表示无返回值*/
    public JsonResult<Void> reg(User user){
        //创建响应结果对象
        userService.reg(user);
        return new JsonResult<>(OK);
    }
//        @RequestMapping("reg")
//        //@ResponseBody//响应结果以json格式进行，给到前端
//        /*Void 表示无返回值*/
//        public JsonResult<Void> reg(User user){
//            //创建响应结果对象
//            JsonResult<Void> result = new JsonResult<Void>();
//            try {
//                userService.reg(user);
//                result.setState(200);
//                result.setMessage("注册成功");
//            } catch (UsernameDuplicatedException e) {
//                result.setState(4000);
//                result.setMessage("用户名被占用");
//            } catch (InsertException e) {
//                result.setState(5000);
//                result.setMessage("注册是产生未知异常");
//            }
//            return result;
}
