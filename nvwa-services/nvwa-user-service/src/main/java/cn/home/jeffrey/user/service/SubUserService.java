package cn.home.jeffrey.user.service;

import cn.home.jeffrey.common.dto.user.UserDto;
import cn.home.jeffrey.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jeffrey
 * @since 2020-03-25
 */
public interface SubUserService extends IService<User> {
    /**
     * 用户注册
     * @param userDto
     * @return
     */
    UserDto register(UserDto userDto);
}
