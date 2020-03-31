package cn.home.jeffrey.business.service;

import cn.home.jeffrey.common.dto.user.UserDto;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/29 21:52
 * @description 总控用户服务接口
 */
public interface BizUserService {
    /**
     * 用户注册
     * @param userDto
     */
    void register(UserDto userDto);
}
