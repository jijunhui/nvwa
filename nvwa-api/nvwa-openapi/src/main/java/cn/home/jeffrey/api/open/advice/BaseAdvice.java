package cn.home.jeffrey.api.open.advice;

import cn.home.jeffrey.base.facade.BaseFacadeService;
import cn.home.jeffrey.common.dto.base.RequestLogDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Async;

/**
 * @author:jeffrey(jeffreyji@aliyun.com)
 * @date: 2020/4/14 0:08
 * @version:1.0.0
 * @description:抽象advice
 */
@Slf4j
public abstract class BaseAdvice {
    /**
     * 最大长度
     */
    protected static final int LOG_MAX_LENGTH = 500;
    /**
     * 请求参数
     */
    protected static ThreadLocal<RequestLogDto> threadRequestLog = new ThreadLocal<>();

    @Reference
    protected BaseFacadeService baseFacadeService;

    @Async
    protected void saveRequestLog(RequestLogDto requestLogDto) {
        log.info("线程:{},执行添加请求日志方法", Thread.currentThread().getName());
        baseFacadeService.addRequestLog(requestLogDto);
    }
}
