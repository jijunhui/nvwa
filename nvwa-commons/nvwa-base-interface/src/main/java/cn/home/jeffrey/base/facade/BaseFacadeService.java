package cn.home.jeffrey.base.facade;

import cn.home.jeffrey.common.dto.RpcResultDto;
import cn.home.jeffrey.common.dto.base.RequestLogDto;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 14:28
 * @description 基础服务对外接口
 */
public interface BaseFacadeService {

    RpcResultDto<Void> addRequestLog(RequestLogDto requestLogDto);
}
