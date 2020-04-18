package cn.home.jeffrey.api.open.vo;

import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.enums.ResultEnum;
import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:jeffrey(jeffreyji@aliyun.com)
 * @date: 2020/4/13 23:35
 * @version:1.0.0
 * @description:返回值
 */
@Data
public class ResponseVo<T> implements Serializable {
    private String appId;
    private String dataType;
    private Long responseTime;
    private String version;
    private String sign;
    private String requestId;

    private String code;
    private String message;
    private T data;


    public ResponseVo() {
    }

    /**
     * @param resultEnum
     */
    public ResponseVo(ResultEnum resultEnum) {
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
    }

    /**
     * 设置错误码
     *
     * @param errCodeEnum
     */
    public void setCodeAndMessage(ErrCodeEnum errCodeEnum, String desc) {
        this.code = errCodeEnum.getCode();
        this.message = StrUtil.isEmpty(desc) ? errCodeEnum.getDesc() : desc;
    }

    /**
     * 结果是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        if (StrUtil.isNotBlank(code) && code.equals(ResultEnum.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }
}
