package cn.home.jeffrey.user.facade;

import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.dto.user.UserDto;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/25 22:14
 * @description 用户子服务对外服务
 */
public interface SubUserFacadeService {

    /**
     * 注册
     * @param userDto
     * @return
     */
    RpcResultDto<UserDto> register(UserDto userDto);

    /**
     * 登录
     * @param userDto
     * @return
     */
    RpcResultDto<UserDto> login(UserDto userDto);
}
