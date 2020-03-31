package cn.home.jeffrey.user.service.impl.facade;

import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.dto.user.UserDto;
import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.enums.ResultEnum;
import cn.home.jeffrey.common.exceptions.SubUserServiceException;
import cn.home.jeffrey.user.facade.SubUserFacadeService;
import cn.home.jeffrey.user.service.SubUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/25 22:14
 * @description 用户子服务对外接口实现类
 */
@Service
@Slf4j
public class SubUserFacadeServiceImpl implements SubUserFacadeService {

    @Autowired
    private SubUserService userService;

    @Override
    public RpcResultDto<UserDto> register(UserDto userDto) {
        RpcResultDto<UserDto> result = new RpcResultDto<>(ResultEnum.SUCCESS);
        try {
            result.setData(userService.register(userDto));
        } catch (Exception e) {
            log.error("用户注册出现异常_请求参数:{},堆栈异常:{}", userDto, e.getMessage(), e);
            if (e instanceof SubUserServiceException) {
                result.setCodeAndMessage(((SubUserServiceException) e).getErrCodeEnum());
            } else {
                result.setCodeAndMessage(ErrCodeEnum.ERR_SUB_USER_SERVICE,"用户注册失败");
            }
        }
        return result;
    }

    @Override
    public RpcResultDto<UserDto> login(UserDto userDto) {
        return null;
    }
}
