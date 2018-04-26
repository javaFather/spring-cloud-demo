package com.wzx.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * @author wangzx
 * @date 2018/4/25 17:10:41
 */
@Aspect
@Component
public class UserLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLogAspect.class);

    /** 切点**/
    @Pointcut("@annotation(com.wzx.demo.annotation.UserLogs)")
    public void userLogs(){

    }

    /**
     * 如果参数是 ProceedingJoinPoint 只能用Around
     * @param proceed
     */
    @Before("userLogs()")
    public void userLogOperation(ProceedingJoinPoint proceed){
        System.out.println("测试切面"+"**************");
    }

}
