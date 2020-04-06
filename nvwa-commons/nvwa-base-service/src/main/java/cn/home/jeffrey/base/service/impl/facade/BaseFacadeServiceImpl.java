package cn.home.jeffrey.base.service.impl.facade;

import cn.home.jeffrey.base.facade.BaseFacadeService;
import cn.home.jeffrey.base.service.BaseRequestLogService;
import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.dto.base.RequestLogDto;
import cn.home.jeffrey.common.enums.ErrCodeEnum;
import cn.home.jeffrey.common.enums.ResultEnum;
import cn.home.jeffrey.common.exceptions.SubUserServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 14:39
 * @description 基础对外服务实现
 */
@Service
@Slf4j
public class BaseFacadeServiceImpl implements BaseFacadeService {
    @Autowired
    private BaseRequestLogService baseRequestLogService;

    @Override
    public RpcResultDto<Void> addRequestLog(RequestLogDto requestLogDto) {
        RpcResultDto<Void> result = new RpcResultDto<>(ResultEnum.SUCCESS);
        try {
            baseRequestLogService.addRequestLog(requestLogDto);
        } catch (Exception e) {
            log.error("添加请求日志出现异常_请求参数:{},堆栈异常:{}", requestLogDto, e.getMessage(), e);
            if (e instanceof SubUserServiceException) {
                result.setCodeAndMessage(((SubUserServiceException) e).getErrCodeEnum());
            } else {
                result.setCodeAndMessage(ErrCodeEnum.ERR_BASE_SERVICE, "添加请求日志失败");
            }
        }
        return result;
    }
}
