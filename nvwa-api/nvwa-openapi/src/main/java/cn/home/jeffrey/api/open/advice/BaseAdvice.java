package cn.home.jeffrey.api.open.advice;

import cn.home.jeffrey.common.dto.base.RequestLogDto;

import java.util.Map;

/**
 * @author:jeffrey(jeffreyji@aliyun.com)
 * @date: 2020/4/14 0:08
 * @version:1.0.0
 * @description:抽象advice
 */
public abstract class BaseAdvice {
    /**
     * 最大长度
     */
    protected static final int LOG_MAX_LENGTH = 500;
    /**
     * 请求参数
     */
    protected static ThreadLocal<RequestLogDto> localParam = new ThreadLocal<>();
}
