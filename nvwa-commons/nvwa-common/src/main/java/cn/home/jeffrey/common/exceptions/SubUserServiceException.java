package cn.home.jeffrey.common.exceptions;

import cn.home.jeffrey.common.enums.ErrCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author jijunhui
 * @Date 2019/5/8 21:01
 * @Version 1.0.0
 * @Description 用户子服务异常
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SubUserServiceException extends ServiceException {
    public SubUserServiceException() {
    }

    /**
     * 子服务必须用这个抛出异常,必须有一个真实的错误描述
     *
     * @param errCodeEnum
     */
    public SubUserServiceException(ErrCodeEnum errCodeEnum) {
        super(errCodeEnum);
    }

    /**
     * 子服务必须用这个抛出异常,必须有一个真实的错误描述
     *
     * @param errCodeEnum
     * @param desc
     */
    public SubUserServiceException(ErrCodeEnum errCodeEnum, String desc) {
        super(errCodeEnum, desc);
    }

}
