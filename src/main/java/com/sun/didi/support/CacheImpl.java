package com.sun.didi.support;

<<<<<<< HEAD
import com.sun.didi.annotation.Cache;
import com.sun.didi.annotation.CachePut;
import com.sun.didi.entity.RegisterUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CacheImpl {

    @Autowired
    private CacheClient cacheClient;

    @Pointcut("@annotation(com.sun.didi.annotation.Cache)")
    public void cacheMethod() {
    }
//标注了cache注解的作为切点
    @Pointcut("@annotation(com.sun.didi.annotation.CachePut)")
    public void cachePutMethod() {
    }
//当前around所执行的方法是标注了cache注解的方法
    @Around("cacheMethod()")
    public Object aroundCache(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint == null) {
            return null;
        }
        Object value = cacheClient.getValue(getKey(joinPoint));
        if (value != null) {
            return value;
        }
        //执行当前被aop代理的方法
        Object proceed = joinPoint.proceed();
        /*从切面值入点获取植入点方法*/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        /*获取切入点方法*/
        Method method = signature.getMethod();
        /*获取方法上的值*/
        Cache cache = method.getAnnotation(Cache.class);
        if (proceed == null) {
            proceed = new RegisterUser();
        }
        cacheClient.putValue(getKey(joinPoint), proceed, cache.expire());
        return proceed;
    }

    @Around("cachePutMethod()")
    public Object aroundCachePut(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint == null) {
            return null;
        }
        Object proceed = joinPoint.proceed();
        /*从切面值入点获取植入点方法*/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        /*获取切入点方法*/
        Method method = signature.getMethod();
        /*获取方法上的值*/
        CachePut cachePut = method.getAnnotation(CachePut.class);
        if (cachePut != null) {
            cacheClient.putValue(getKey(joinPoint), proceed, cachePut.expire());
        }
        return proceed;
    }


    /**
     * 根据参数生成cachekey
     *
     * @param joinPoint
     * @return
     */
    private String getKey(ProceedingJoinPoint joinPoint) {//首先通过传递参数拿到方法
        String clazzName = joinPoint.getTarget().getClass().getName(); //获取类名
        String method = joinPoint.getSignature().getName();//获取方法名
        String result = clazzName + "_" + method;
        if (joinPoint.getArgs() == null) {
            return result;
        }
        for (Object key : joinPoint.getArgs()) {//通过循环拿到里边的对应的参数和参数值
            if (key != null) {
                result += "_" + key.toString();
            }
        }
        return result;
    }

=======

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheImpl {
    @Autowired
    private RedisCache redisCache;
/*    @Pointcut("@annotation(com.sun.didi.annotation.Cache)")
    public void cacheMethod(){

    }
    public Object aroundCache(ProceedingJoinPoint joinPoint){
        if(joinPoint==null){
            return null;
        }
        return null;
    }*/
>>>>>>> b63ec687f91c8addc3617f8aeb34f03cd8971bae
}
