package cn.home.jeffrey.common.dto;

import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.enums.ResultEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/25 23:19
 * @description 远端传输对象
 */
@Data
@Accessors(chain = true)
public class RpcResultDto<T> implements Serializable {
    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;
    /**
     * errCodeEnum 错误码
     */
    private ErrCodeEnum errCodeEnum;
    /**
     * 数据
     */
    private T data;

    public RpcResultDto() {
    }

    /**
     * @param resultEnum
     */
    public RpcResultDto(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    /**
     * 设置错误码
     *
     * @param errCodeEnum
     */
    public void setCodeAndMessage(ErrCodeEnum errCodeEnum) {
        this.code = errCodeEnum.getCode();
        this.message = errCodeEnum.getDesc();
        this.errCodeEnum = errCodeEnum;
    }

    /**
     * 设置错误码
     *
     * @param errCodeEnum
     */
    public void setCodeAndMessage(ErrCodeEnum errCodeEnum, String desc) {
        this.code = errCodeEnum.getCode();
        this.message = StringUtils.isEmpty(desc) ? errCodeEnum.getDesc() : desc;
        this.errCodeEnum = errCodeEnum;
        this.errCodeEnum.setDesc(this.message);
    }

    /**
     * 结果是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        if (StringUtils.isNotEmpty(code) && ResultEnum.SUCCESS.getCode().equals(code)) {
            return true;
        }
        return false;
    }
}
