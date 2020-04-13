package cn.home.jeffrey.common.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 请求日志
 * </p>
 *
 * @author jeffrey
 * @since 2020-04-04
 */
@Data
@Accessors(chain = true)
public class RequestLogDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String requestId;
    /**
     * appId
     */
    private String appid;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回结果
     */
    private String responseResult;

    /**
     * 请求时间
     */
    private Long requestTime;

    /**
     * 返回结果时间
     */
    private Long responseTime;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 类型
     */
    private String type;

    /**
     * 耗时(ms)
     */
    private Long cost;


}
