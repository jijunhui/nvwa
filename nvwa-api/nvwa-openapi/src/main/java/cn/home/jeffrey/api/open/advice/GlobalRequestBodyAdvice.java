package cn.home.jeffrey.api.open.advice;

import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.exceptions.ServiceException;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/5 22:28
 * @description 全局请求参数处理
 */

@ControllerAdvice(basePackages = "cn.home.jeffrey.api.open.controller")
@Slf4j
public class GlobalRequestBodyAdvice implements RequestBodyAdvice {
    /**
     * 最大长度
     */
    private static final int LOG_MAX_LENGTH = 500;

    /**
     * return false 则不执行下面的方法。
     *
     * @param methodParameter
     * @param type
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        return new HttpInputMessage() {
            @Override
            public InputStream getBody() throws IOException {

                log.info("【请求的方法】:{}", methodParameter.getMethod().getName());
                // 从流中获取参数
                InputStream inputStream = httpInputMessage.getBody();
                String result = IoUtil.read(inputStream, StandardCharsets.UTF_8);
                // 关闭流
                IoUtil.close(inputStream);

                log.info("【请求参数body】:{}", StrUtil.isBlank(result) || result.length() < LOG_MAX_LENGTH ? result : result.length());
                HttpHeaders headers = httpInputMessage.getHeaders();
                if (null == headers) {
                    throw new ServiceException(ErrCodeEnum.PARAM_ISNULL, "请求头不能为空");
                }
                List<String> appIdArr = headers.get("appId");
                if (CollUtil.isEmpty(appIdArr)) {
                    throw new ServiceException(ErrCodeEnum.PARAM_ISNULL, "应用ID不能为空");
                }
                String appId = appIdArr.get(0);
                if (StrUtil.isBlank(appId)) {
                    throw new ServiceException(ErrCodeEnum.PARAM_ISNULL, "应用ID不能为空");
                }

                List<String> dArr = headers.get("dataType");
                if (CollUtil.isEmpty(dArr)) {
                    throw new ServiceException(ErrCodeEnum.PARAM_ISNULL, "数据传输类型不能为空");
                }
                String dataType = dArr.get(0);
                if (StrUtil.isBlank(dataType)) {
                    throw new ServiceException(ErrCodeEnum.PARAM_ISNULL, "数据传输类型不能为空");
                }

                log.info("【请求参数head】:{}", StrUtil.builder(appId, StrUtil.UNDERLINE, dataType).toString());
                log.debug("统一拦截_收到传输参数：{}", result);
                return IoUtil.toUtf8Stream(result);
            }

            @Override
            public HttpHeaders getHeaders() {
                return httpInputMessage.getHeaders();
            }
        };
    }

    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }
}
