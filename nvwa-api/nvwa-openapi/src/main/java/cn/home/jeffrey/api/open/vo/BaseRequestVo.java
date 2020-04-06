package cn.home.jeffrey.api.open.vo;

import java.io.Serializable;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/4 17:13
 * @description 基础请求vo
 */
public class BaseRequestVo implements Serializable {
    private String appId;
    private String dataType;
    private Long requestTime;
    private String version;
    private String sign;
}
