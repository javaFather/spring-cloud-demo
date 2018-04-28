package com.wzx.demo.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.wzx.demo.annotation.UserLogs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 日志切面
 * @author wangzx
 * @date 2018/4/25 17:10:41
 */
@Aspect
@Component
public class UserLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLogAspect.class);
    private UserLogs logs;

    /** 切点**/
    @Pointcut("@annotation(com.wzx.demo.annotation.UserLogs)")
    public void userLogs(){

    }

    /**
     * Around 参数只能用 ProceedingJoinPoint
     * before after 参数只能用 JoinPoint
     * url 参数在arguments里
     *
     */
    @Before("userLogs()")
    public void userLogOperation(JoinPoint joinPoint){
        /** 请求参数**/
        JSONObject json = getMethodParams(joinPoint);
        /**注解参数**/
        Map<String, Object> map = getAnnotationParams(joinPoint);
        // TODO 记录用户操作日志代码省略
    }


    /**
     * 获取方法参数
     */
    private JSONObject getMethodParams(JoinPoint jp){
        /** 方法参数**/
        Object[] args = jp.getArgs();
        /**方法**/
        MethodSignature method = (MethodSignature) jp.getSignature();
        /**方法参数名称**/
        String[] parameterNames = method.getParameterNames();
        JSONObject json = new JSONObject();
        for (int i=0;i<args.length;i++){
            if (null == args[i] || args[i] instanceof Model || args[i] instanceof ModelMap || args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile || args[i] instanceof HttpSession) {
                continue;
            }
            json.put(parameterNames[i],args[i]);
        }
        return json;
    }

    /**获取注解参数**/
    private Map<String,Object> getAnnotationParams(JoinPoint jp){
        MethodSignature method = (MethodSignature) jp.getSignature();
        Method params = method.getMethod();
        logs = params.getAnnotation(UserLogs.class);
        Map<String,Object> map = Maps.newHashMap();
        if(logs !=null){
           map.put("remark",logs.remark());
           map.put("operation",logs.operation());
        }
        return map;
    }

}
