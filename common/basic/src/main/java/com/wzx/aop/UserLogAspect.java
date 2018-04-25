package com.wzx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志切面
 * @author wangzx
 * @date 2018/4/25 17:10:41
 */
@Aspect
public class UserLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLogAspect.class);

    /** 切点**/
    @Pointcut("@annotation(com.wzx.annotation.UserLogs)")
    public void userLogs(){

    }

    @Around("userLogs()")
    public Object userLogOperation(ProceedingJoinPoint proceed){

        return null;
    }

}
