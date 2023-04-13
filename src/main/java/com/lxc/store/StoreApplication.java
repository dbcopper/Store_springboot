package com.lxc.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mapperscan注解指定当前项目中mapper接口路径的位置，在项目启动的时候会自动加载所有的接口
@MapperScan("com.lxc.store.mapper")

public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
