package com.zmj.project.common.aspect;

import com.zmj.project.common.domain.RestfulResult;
import com.zmj.project.common.enums.ErrorCode;
import com.zmj.project.common.util.ZmjUtil;
import com.zmj.project.common.validate.exception.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 所有Service的切面，记日志，记录返回，参数校验
 * @author zmj
 */
@Aspect
@Component
public class ServiceAspect {
    private static final Logger logger  = LoggerFactory.getLogger(ServiceAspect.class);

    long startTime;
    long endTime;

    @Pointcut(value = "execution(public * com.zmj.project.service.*.*(..))")
    public void jsonService(){

    }

    /**
     * 记录进入control的参数
     * @param joinPoint
     */
    @Before("jsonService()")
    public void doBefore(JoinPoint joinPoint){
        startTime= System.currentTimeMillis();
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }

    /**
     * 记录response
     * @param object
     */
    @AfterReturning(pointcut = "jsonService()",returning = "object")
    public void doAfterReturning(Object object){
        endTime= System.currentTimeMillis();
        logger.info("处理时间={}ms", endTime-startTime);
    }

    /**
     * 获取真实ip地址 适配cdn和nginx等代理
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
