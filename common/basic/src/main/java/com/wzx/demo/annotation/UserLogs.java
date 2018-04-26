package com.wzx.demo.annotation;

import com.wzx.demo.aop.UserLogAspect;

import java.lang.annotation.*;

/**
 * 日志注解
 * @author wangzx
 * @date 2018/4/25 15:33:57
 * @see UserLogAspect
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserLogs {
    /** 备注**/
    String remark() default "";
    /**操作**/
    String operation();

}
