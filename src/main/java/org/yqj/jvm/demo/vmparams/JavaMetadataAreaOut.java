package org.yqj.jvm.demo.vmparams;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.yqj.jvm.demo.vmparams.HeapOOMTest.OOMObject;

import java.lang.reflect.Method;

/**
 * Created by yaoqijun on 2018/6/2.
 * email: yaoqijunmail@foxmail.com
 * java7: -XX:PermSize=10M -XX:MaxPermSize=10M
 * java8: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class JavaMetadataAreaOut {
    public static void main(String[] args) {
        System.out.println("main");

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });

            enhancer.create();
        }
    }
}
