package cn.home.jeffrey.api.open.controller;

import cn.home.jeffrey.api.open.service.OpenUserService;
import cn.home.jeffrey.api.open.vo.ResponseVo;
import cn.home.jeffrey.common.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 17:11
 * @description openApi用户controller
 */
@RestController
@RequestMapping("/openapi/user")
@Slf4j
public class OpenUserController {
    @Autowired
    private OpenUserService openUserService;

    @PostMapping("register")
    public ResponseVo<UserDto> register(@RequestBody UserDto userDto) {
        return openUserService.register(userDto);
    }

}
