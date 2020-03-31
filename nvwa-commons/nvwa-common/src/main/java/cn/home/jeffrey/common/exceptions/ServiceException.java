package cn.home.jeffrey.common.exceptions;

import cn.home.jeffrey.common.enums.ErrCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author jijunhui
 * @Date 2019/5/8 21:01
 * @Version 1.0.0
 * @Description 服务异常
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {
    /**
     * 错误码
     */
    protected ErrCodeEnum errCodeEnum;

    public ServiceException() {
    }

    /**
     * 子服务必须用这个抛出异常,必须有一个真实的错误描述
     *
     * @param errCodeEnum
     */
    public ServiceException(ErrCodeEnum errCodeEnum) {
        super(errCodeEnum.toString());
        this.errCodeEnum = errCodeEnum;
    }

    /**
     * 子服务必须用这个抛出异常,必须有一个真实的错误描述
     *
     * @param errCodeEnum
     * @param desc
     */
    public ServiceException(ErrCodeEnum errCodeEnum, String desc) {
        super(errCodeEnum.setDesc(desc).toString());
        this.errCodeEnum = errCodeEnum;
        this.errCodeEnum.setDesc(StringUtils.isNotEmpty(desc) ? desc : errCodeEnum.getDesc());
    }
}
