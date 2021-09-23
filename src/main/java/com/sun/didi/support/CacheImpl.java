package com.sun.didi.support;


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
}
