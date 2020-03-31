package cn.home.jeffrey.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/3/26 0:03
 * @description facade接口请求日志
 */
@Aspect
@Component
@Slf4j
public class FacadeServiceLogAspect {
    /**
     * jdk1.8 线程安全的时间format
     */
    private final static DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final static ThreadLocal<StringBuffer> LOGSTRINGBUFFER = new ThreadLocal<>();

    /**
     * 指定切点 所有facade接口的请求日志
     */
    @Pointcut("execution(public * cn.home.jeffrey..*.service.facade.impl.*.*(..))")
    public void log() {
    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     *
     * @param pjp
     * @return
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        StringBuffer logBuffer = new StringBuffer("facade服务_统一拦截_开始:{}.{}");
        Signature signature = pjp.getSignature();
        // 获取目标方法的参数信息
        String[] params = ((MethodSignature) signature).getParameterNames();
        String method = ((MethodSignature) signature).getMethod().getName();
        Object[] values = pjp.getArgs();
        if (null != params && params.length > 0 && null != values && values.length > 0 && params.length == values.length) {
            logBuffer.append("(");
            for (int i = 0; i < params.length; i++) {
                logBuffer.append(params[i]).append("(").append(values[i]).append(")");
                if (i != params.length - 1) {
                    logBuffer.append(",");
                }
            }
            logBuffer.append(")");
        } else {
            logBuffer.append("()");
        }
        log.info(logBuffer.toString(), signature.getDeclaringType().getSimpleName(), ((MethodSignature) signature).getMethod().getName());
        logBuffer.setLength(0);
        Object o = null;
        try {
            o = pjp.proceed();
            logBuffer.append("facade服务_统一拦截_结束:{}.{}_返回结果:{},耗时:{}ms");
            log.info(logBuffer.toString(), signature.getDeclaringType().getSimpleName(), ((MethodSignature) signature).getMethod().getName(), o, (System.currentTimeMillis() - start));
        } catch (Throwable throwable) {
            logBuffer.append("facade服务_统一拦截_结束:{}.{}_异常:{},耗时:{}ms");
            log.error(logBuffer.toString(), signature.getDeclaringType().getSimpleName(), ((MethodSignature) signature).getMethod().getName(), throwable.getMessage(), throwable, (System.currentTimeMillis() - start));
        }

        return o;

    }
}
