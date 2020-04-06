package cn.home.jeffrey.api.open.service.impl;

import cn.home.jeffrey.api.open.service.OpenUserService;
import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.dto.user.UserDto;
import cn.home.jeffrey.common.validate.BaseParamValidator;
import cn.home.jeffrey.user.facade.SubUserFacadeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 16:55
 * @description openApi用户接口实现类
 */
@Service
public class OpenUserServiceImpl implements OpenUserService {

    @Reference
    private SubUserFacadeService subUserFacadeService;

    @Override
    public UserDto register(UserDto userDto) {
        RpcResultDto<UserDto> registerResult = subUserFacadeService.register(userDto);
        BaseParamValidator.validateRpcResult(registerResult);
        return registerResult.getData();
    }
}
