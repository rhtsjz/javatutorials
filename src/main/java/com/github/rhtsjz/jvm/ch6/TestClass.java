package com.github.rhtsjz.jvm.ch6;

/**
 * Created by smile on 2017/4/10.
 */
public class TestClass {
    private int m;

    public int inc() {
        return m + 1;
    }

    public int inc1(int exType) throws Throwable {
        int x;
        try {
            x = 1;
            if (exType == 1) {
                throw new Throwable("" + exType);
            } else if (exType == 2) {
                throw new Exception("" + exType);
            }
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static void main(String[] args) {
        try {
            int x = new TestClass().inc1(0);
            System.out.println(x);
        } catch (Throwable throwable) {
            System.out.println("i am in catch 0");
            throwable.printStackTrace();
        }
        try {
            int x = new TestClass().inc1(1);
            System.out.println(x);
        } catch (Throwable throwable) {
            System.out.println("i am in catch 1");
            throwable.printStackTrace();
        }

        try {
            int x = new TestClass().inc1(2);
            System.out.println(x);
        } catch (Throwable throwable) {
            System.out.println("i am in catch 2");
            throwable.printStackTrace();
        }
    }
}
