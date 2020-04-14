package cn.home.jeffrey.api.open.advice;

import cn.home.jeffrey.api.open.vo.ResponseVo;
import cn.home.jeffrey.common.dto.base.RequestLogDto;
import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author jijunhui
 * @Date 2018/12/25 17:12
 * @Version 1.0.0
 * @Description 统一异常拦截
 */
@RestControllerAdvice(basePackages = "cn.home.jeffrey.api.open.controller")
@Slf4j
public class ExceptionAdvice extends BaseAdvice {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVo<Void> defaultException(HttpServletRequest request, Exception e) {
        RequestLogDto requestLogDto = threadRequestLog.get();
        ResponseVo<Void> responseVO = new ResponseVo<>();
        responseVO.setRequestId(System.currentTimeMillis() + "");
        responseVO.setResponseTime(System.currentTimeMillis());
        requestLogDto.setResponseTime(responseVO.getResponseTime());
        if (null != requestLogDto) {
            responseVO.setAppId(requestLogDto.getAppId());
            responseVO.setRequestId(requestLogDto.getRequestId());
        }
        // 拦截意外出现异常的情况
        if (e instanceof ServiceException) {
            log.error("控制层拦截意外出现异常的情况_请求的url:{},出现异常:{}", request.getRequestURL(), e.getMessage(), e);
            ServiceException e1 = (ServiceException) e;
            responseVO.setCodeAndMessage(e1.getErrCodeEnum());
            log.info("【返回结果】:{}", responseVO);
            saveRequestLog(requestLogDto);
            return responseVO;
        }
        if (e instanceof Exception) {
            log.error("控制层拦截异常_请求的url:{},出现异常:{}", request.getRequestURL(), e.getMessage(), e);
            responseVO.setCodeAndMessage(ErrCodeEnum.ERR_SYSTEM_SERVICE);
            log.info("【返回结果】:{}", responseVO);
            saveRequestLog(requestLogDto);
            return responseVO;
        }
        return null;
    }
}