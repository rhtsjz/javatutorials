package com.github.rhtsjz.json.org;

//import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class OrgMain {

    public static void main(String[] args) {
        String str = "\n\b\t\f\r{\"name\":\"熊二\",\"age\":1e3, \"days\":[1,2,3]}";
        str = "[{\"name\":\"熊大\",\"age\":3},{\"name\":\"熊二\",\"age\":2}]";
//        JSONObject jsonObject = new JSONObject(str);
//        String textStr = jsonObject.toString();
//        JSONArray jsonArray = new JSONArray(str);
//        String textStr = jsonArray.toString(2);

        Map<String, Object> map = new HashMap<>();
        Bear bear = new Bear("熊大", 3, 1);
//        JSONObject jsonObject = new JSONObject(bear);
//        String textStr = jsonObject.toString(2);
        Bear[] bears = new Bear[2];
        bears[0] = bear;
        bears[1] = new Bear("熊二", 3, 2);
        JSONArray jsonArray = new JSONArray(bears);
        String textStr = jsonArray.toString(2);

        System.out.println(textStr);
    }
}
