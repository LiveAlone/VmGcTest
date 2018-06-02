package org.yqj.jvm.demo.vmparams;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置参数 -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOMTest {

    public static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<>();
        while (true){
            oomObjectList.add(new OOMObject());
        }
    }

}
