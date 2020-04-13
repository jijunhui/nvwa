package cn.home.jeffrey.api.open.advice;

import cn.home.jeffrey.common.dto.base.RequestLogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/5 22:28
 * @description 全局请求参数处理
 */

@ControllerAdvice(basePackages = "cn.home.jeffrey.api.open.controller")
@Slf4j
public class GlobalResponseBodyAdvice<BaseResponseVo> extends BaseAdvice implements ResponseBodyAdvice {
    /**
     * 最大长度
     */
    private static final int LOG_MAX_LENGTH = 500;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("【返回结果】:{}", o);
        RequestLogDto requestLogDto = localParam.get();
        requestLogDto.setResponseResult(o.toString());
        requestLogDto.setResponseTime(System.currentTimeMillis());
        log.info("--->>>请求参数与响应结果<----:{}",requestLogDto);
        localParam.remove();
        return o;
    }
}
