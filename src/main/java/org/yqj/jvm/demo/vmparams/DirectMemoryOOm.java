package org.yqj.jvm.demo.vmparams;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by yaoqijun on 2018/6/2.
 * email: yaoqijunmail@foxmail.com
 * args : -XX:MaxDirectMemorySize=10m
 */
public class DirectMemoryOOm {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("main");
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        while (true){
            unsafe.allocateMemory(1024 * 1024);
        }
    }
}
