package com.wzx.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
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
public class UserLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLogAspect.class);

    /** 切点**/
    @Pointcut("@annotation(com.wzx.demo.annotation.UserLogs)")
    public void userLogs(){

    }

    @Before("userLogs()")
    public void userLogOperation(ProceedingJoinPoint proceed){
        System.out.println("测试切面"+"**************");
    }

}
