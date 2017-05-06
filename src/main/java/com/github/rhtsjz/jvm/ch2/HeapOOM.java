package com.github.rhtsjz.jvm.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smile on 2017/3/30.
 * <p>
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
