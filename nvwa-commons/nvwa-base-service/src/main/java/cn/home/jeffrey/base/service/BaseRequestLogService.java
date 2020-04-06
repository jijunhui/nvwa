package cn.home.jeffrey.base.service;

import cn.home.jeffrey.base.entity.RequestLog;
import cn.home.jeffrey.common.dto.base.RequestLogDto;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 请求日志 服务类
 * </p>
 *
 * @author jeffrey
 * @since 2020-04-04
 */
public interface BaseRequestLogService extends IService<RequestLog> {
    void addRequestLog(RequestLogDto requestLogDto);
}
