package cn.home.jeffrey.api.open.service;

import cn.home.jeffrey.api.open.vo.ResponseVo;
import cn.home.jeffrey.common.dto.user.UserDto;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 16:50
 * @description openApi 用户服务
 */
public interface OpenUserService {
    /**
     * 用户注册
     *
     * @param userDto
     * @return
     */
    ResponseVo<UserDto> register(UserDto userDto);
}
