package cn.home.jeffrey.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 请求日志
 * </p>
 *
 * @author jeffrey
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_request_log")
public class RequestLog implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 耗时(ms)
     */
    private Long cost;


}
