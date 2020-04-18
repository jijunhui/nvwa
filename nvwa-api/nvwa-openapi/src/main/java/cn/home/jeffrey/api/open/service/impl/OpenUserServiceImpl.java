package cn.home.jeffrey.api.open.service.impl;

import cn.home.jeffrey.api.open.service.OpenUserService;
import cn.home.jeffrey.api.open.vo.ResponseVo;
import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.dto.user.UserDto;
import cn.home.jeffrey.common.enums.ResultEnum;
import cn.home.jeffrey.common.lettuce.CacheStandaloneClient;
import cn.home.jeffrey.common.validate.BaseParamValidator;
import cn.home.jeffrey.user.facade.SubUserFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 16:55
 * @description openApi用户接口实现类
 */
@Service
@Slf4j
public class OpenUserServiceImpl implements OpenUserService {

    @Reference
    private SubUserFacadeService subUserFacadeService;

    @Override
    public ResponseVo<UserDto> register(UserDto userDto) {
        log.info("查询缓存信息:{}", CacheStandaloneClient.get("aaaa"));
        ResponseVo<UserDto> result = new ResponseVo<>(ResultEnum.SUCCESS);
        RpcResultDto<UserDto> registerResult = subUserFacadeService.register(userDto);
        BaseParamValidator.validateRpcResult(registerResult);
        result.setData(registerResult.getData());
        return result;
    }
}
