package cn.home.jeffrey.common.validate;

import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.exceptions.ServiceException;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/31 21:29
 * @description 抽象参数校验
 */
public abstract class BaseParamValidator {
    /**
     * 远程结果返回值校验
     *
     * @param rpcResultDto 远端接口返回的结果
     * @return
     */
    public final static boolean validateRpcResult(RpcResultDto<?> rpcResultDto, ErrCodeEnum errCodeEnum) {
        if (null == rpcResultDto) {
            throw new ServiceException(errCodeEnum);
        }
        if (!rpcResultDto.isSuccess()) {
            throw new ServiceException(rpcResultDto.getErrCodeEnum());
        }
        return true;
    }

    /**
     * 远程结果返回值校验
     *
     * @param baseRpcResult 远端接口返回的结果
     * @return
     */
    public final static boolean validateRpcResult(RpcResultDto<?> baseRpcResult) {
        return validateRpcResult(baseRpcResult, ErrCodeEnum.ERR_SYSTEM_SERVICE);
    }

}
