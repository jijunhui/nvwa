package cn.home.jeffrey.business.controller;

import cn.home.jeffrey.business.service.BizUserService;
import cn.home.jeffrey.common.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/29 22:01
 * @description 用户总控测试
 */
@RestController
@RequestMapping("user")
public class BizUserController {

    @Autowired
    private BizUserService bizUserService;

    @RequestMapping("register")
    public String register(@RequestBody UserDto userDto) {
        bizUserService.register(userDto);
        return "success";
    }
}
