package cn.home.jeffrey.api.open.advice;

import cn.home.jeffrey.api.open.vo.ResponseVo;
import cn.home.jeffrey.common.dto.base.RequestLogDto;
import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;
import java.util.Map;

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
        RequestLogDto requestLogDto = threadRequestLog.get();
        requestLogDto.setResponseTime(System.currentTimeMillis());
        if (o instanceof ResponseVo) {
            ResponseVo responseVo = (ResponseVo) o;
            responseVo.setRequestId(requestLogDto.getRequestId());
            responseVo.setAppId(requestLogDto.getAppId());
            Object data = responseVo.getData();
            if (data instanceof Void) {
                requestLogDto.setResponseResult("");
            } else if (data instanceof List) {
                requestLogDto.setResponseResult("size:" + ((List) data).size());
            } else if (data instanceof Map) {
                if (((Map) data).size() < 20) {
                    requestLogDto.setResponseResult(data.toString());
                } else {
                    requestLogDto.setResponseResult("size:" + ((Map) data).size());
                }
            } else {
                requestLogDto.setResponseResult(responseVo.getData().toString());
            }
            log.info("--->>>请求参数与响应结果<----:{}", requestLogDto);
            saveRequestLog(requestLogDto);
            threadRequestLog.remove();
            return responseVo;
        }
        throw new ServiceException(ErrCodeEnum.ERR_SYSTEM_SERVICE, "返回对象不是ResponseVo的格式");
    }
}
