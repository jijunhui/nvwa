package cn.home.jeffrey.base.service.impl;

import cn.home.jeffrey.base.entity.RequestLog;
import cn.home.jeffrey.base.mapper.RequestLogMapper;
import cn.home.jeffrey.base.service.BaseRequestLogService;
import cn.home.jeffrey.common.dto.base.RequestLogDto;
import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.exceptions.ServiceException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 请求日志 服务实现类
 * </p>
 *
 * @author jeffrey
 * @since 2020-04-04
 */
@Service
@Slf4j
public class BaseRequestLogServiceImpl extends ServiceImpl<RequestLogMapper, RequestLog> implements BaseRequestLogService {

    @Override
    @Transactional
    public void addRequestLog(RequestLogDto requestLogDto) {
        if (null == requestLogDto || StringUtils.isAnyEmpty(requestLogDto.getAppid(), requestLogDto.getRequestMethod())) {
            log.info("添加请求日志_对象或者参数不能为空");
            throw new ServiceException(ErrCodeEnum.PARAM_ISNULL, "添加请求日志，参数不能为空");
        }
        if (null != requestLogDto.getRequestTime() && null != requestLogDto.getResponseTime()) {
            requestLogDto.setCost(requestLogDto.getResponseTime() - requestLogDto.getRequestTime());
        }
        RequestLog requestLog = new RequestLog();
        BeanUtils.copyProperties(requestLogDto, requestLog);
        requestLog.setCreateTime(LocalDateTime.now());
        save(requestLog);
        log.info("请求日志添加成功！");
    }
}
