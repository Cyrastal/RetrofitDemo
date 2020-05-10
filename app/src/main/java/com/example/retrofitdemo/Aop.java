package com.example.retrofitdemo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aop {
    @Around("execution(*android.app.Activity.on**(..))")
public void getTime(ProceedingJoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.toShortString();
        long time = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.i("Retrofit", name+"cost"+(System.currentTimeMillis() - time));


}
}
