package com.github.rhtsjz.jvm.ch7;

/**
 * Created by smile on 2017/5/16.
 */
public class CInitTest {

    static {
        i = 0;
        // 非法向前引用
//        System.out.println(i);
    }
    static int i = 1;

    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

//    public static void main(String[] args) {
//        System.out.println(Sub.B);
//    }

    static class DeadLoopClass {
        static int DELAY_INIT = 1000;
        static {
            // 如果没有下面的if语句，编译器会报错
            if (true){
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (DELAY_INIT > 0) {
                    DELAY_INIT --;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run over");
            }
        };

        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);

        t1.start();
        t2.start();
    }
}
