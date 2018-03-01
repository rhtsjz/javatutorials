package com.github.rhtsjz.json.fast;

import com.alibaba.fastjson.JSON;

public class FastMain {
    public static void main(String[] args) {
        String str = "\n\b\t\f\r{\"name\":\"熊二\",\"age\":1e3, \"days\":[1,2,3]}";
        str = "[{\"name\":\"熊大\",\"age\":3},{\"name\":\"熊二\",\"age\":2}]";
        Object o = JSON.parse(str);
        String textStr = JSON.toJSONString(o);
        System.out.println(textStr);
    }
}
