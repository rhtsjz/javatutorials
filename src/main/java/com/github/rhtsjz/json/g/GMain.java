package com.github.rhtsjz.json.g;

import com.google.gson.Gson;

public class GMain {
    public static void main(String[] args) {

        /*
          Object Examples
         */

        // Serialization
        BagOfPrimitives obj = new BagOfPrimitives(11, "vv", 22);
        Gson gson = new Gson();
        final String[] jsons = new String[1];


        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                Thread.currentThread().setName("Thread-" + finalI);
                jsons[0] = gson.toJson(obj);
                System.out.println(jsons[0]);
                BagOfPrimitives obj11 = gson.fromJson(jsons[0], BagOfPrimitives.class);
                System.out.println(obj11);
            }).start();
        }



    }
}
