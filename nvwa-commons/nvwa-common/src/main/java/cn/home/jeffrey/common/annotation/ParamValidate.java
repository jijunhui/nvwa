package cn.home.jeffrey.common.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author jijunhui
 * @Date 2019/3/27 13:10
 * @Version 1.0.0
 * @Description 参数校验
 */
@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamValidate {
    /**
     * 参数列表
     * @return
     */
    String[] params() default {};
}
