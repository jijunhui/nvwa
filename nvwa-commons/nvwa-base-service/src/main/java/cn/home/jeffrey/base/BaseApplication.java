package cn.home.jeffrey.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 14:23
 * @description 基础服务启动类
 */
@SpringBootApplication
@MapperScan("cn.home.jeffrey.base.mapper")
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
