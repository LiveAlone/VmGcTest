package org.yqj.jvm.demo.gc;

/**
 * Created by yaoqijun on 2018/6/2.
 * email: yaoqijunmail@foxmail.com
 */
public class ReferenceCountingGc {

    public Object instance = null;

    public static void main(String[] args) {

        ReferenceCountingGc a = new ReferenceCountingGc();
        ReferenceCountingGc b = new ReferenceCountingGc();
        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }
}
