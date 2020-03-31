package cn.home.jeffrey.business.service.impl;

import cn.home.jeffrey.business.service.BizUserService;
import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.dto.user.UserDto;
import cn.home.jeffrey.common.validate.BaseParamValidator;
import cn.home.jeffrey.user.facade.SubUserFacadeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/29 21:54
 * @description 总控服务实现类
 */
@Service
public class BizUserServiceImpl implements BizUserService {
    @Reference
    private SubUserFacadeService subUserFacadeService;

    @Override
    public void register(UserDto userDto) {
        RpcResultDto<UserDto> registerResult = subUserFacadeService.register(userDto);
        BaseParamValidator.validateRpcResult(registerResult);
    }
}
