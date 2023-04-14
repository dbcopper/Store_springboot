package com.lxc.store.service.util;

import java.io.Serializable;

/*json格式的数据进行响应*/
/*只要有一个泛型，就要在class中声明*/
/*处理响应*/
/*Serializable可以实现序列化，就是把java对象转化为字节序列的过程*/
public class JsonResult<E> implements Serializable {
    /*状态码*/
    private Integer state;
    /*描述信息*/
    private String message;
    /*使用泛型来表示任何的数据类型*/
    private E data;

    /*无参数的构造方法*/
    public JsonResult() {
        super();
    }
    /**/
    public JsonResult(Integer state) {
        super();
        this.state = state;
    }
    public JsonResult(Throwable e) {
        super();
        this.message = e.getMessage();
    }


    public JsonResult(Integer state, E data) {
        super();
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
