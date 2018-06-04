package org.yqj.jvm.demo.vmparams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoqijun on 2018/6/2.
 * email: yaoqijunmail@foxmail.com
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class ConstantPoolOutOfMemory {
    public static void main(String[] args) {
        System.out.println("main");
        List<String> contants = new ArrayList<>();
        int i = 0;
        while (true){
            contants.add(String.valueOf(i).intern());
        }
    }
}
