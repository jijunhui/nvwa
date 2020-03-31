package cn.home.jeffrey.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/22 23:55
 * @description 用户服务启动类
 */
@SpringBootApplication
@MapperScan("cn.home.jeffrey.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
