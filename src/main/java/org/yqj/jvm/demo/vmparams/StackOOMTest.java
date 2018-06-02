package org.yqj.jvm.demo.vmparams;

/**
 * Created by yaoqijun on 2018/6/2.
 * email: yaoqijunmail@foxmail.com
 * params : -Xss256k
 */
public class StackOOMTest {

    private int stack = 1;

    public void stackLeak(){
        stack ++ ;
        stackLeak();
    }

    public static void main(String[] args) {
//        System.out.println("main");
        StackOOMTest test = new StackOOMTest();
        try {
            test.stackLeak();
        }catch (Throwable e){
            System.out.println("current stack length is " + test.stack);
            throw e;
        }
    }
}
