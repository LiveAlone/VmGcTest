package org.yqj.jvm.demo.vmparams;

/**
 * Created by yaoqijun on 2018/6/2.
 * email: yaoqijunmail@foxmail.com
 * -Xss2M
 */
public class NativeOutOfMemory {
    public static void main(String[] args) {
        System.out.println("test");
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(10000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }
}
