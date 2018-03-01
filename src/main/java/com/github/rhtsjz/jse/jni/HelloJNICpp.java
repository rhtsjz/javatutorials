package com.github.rhtsjz.jse.jni;

public class HelloJNICpp {
    static {
        System.loadLibrary("jniNative"); // hello.dll (Windows) or libhello.so (Unixes)
    }

//    // Native method declaration
//    private native void sayHello();
//
//
//    // Declare a native method average() that receives two ints and return a double containing the average
//    private native double average(int i1, int i2);

    // Native method that receives a Java String and return a Java String
    private native String sayHello(String msg);

//    // Declare a native method sumAndAverage() that receives an int[] and
//    //  return a double[2] array with [0] as sum and [1] as average
//    private native double[] sumAndAverage(int[] numbers);
//
//    // Instance variables
//    private int number = 88;
//    private String message = "Hello from Java";
//
//    // Declare a native method that modifies the instance variables
//    private native void modifyInstanceVariable();
//
//    // Static variables
//    private static double numberStatic = 55.66;
//
//    // Declare a native method that modifies the static variable
//    private native void modifyStaticVariable();
//
//
//    // Declare a native method that calls back the Java methods below
//    private native void nativeMethod();
//
//    // To be called back by the native code
//    private void callback() {
//        System.out.println("In Java");
//    }
//
//    private void callback(String message) {
//        System.out.println("In Java with " + message);
//    }
//
//    private double callbackAverage(int n1, int n2) {
//        return ((double)n1 + n2) / 2.0;
//    }
//
//    // Static method to be called back
//    private static String callbackStatic() {
//        return "From static Java method";
//    }
//
//
//    // Native method that calls back the constructor and return the constructed object.
//    // Return an Integer object with the given int.
//    private native Integer getIntegerObject(int number);

    // Test Driver
    public static void main(String[] args) {
        HelloJNICpp helloJNICpp = new HelloJNICpp();
//        helloJNICpp.sayHello();  // Invoke native method
//
//        double average = helloJNICpp.average(3, 5);
//        System.out.println("In Java, the average of 3 and 5 is " + average);

        String result = helloJNICpp.sayHello("VIPKID");
        System.out.println("In Java, the returned string is: " + result);

//        int[] numbers = {22, 33, 33};
//        double[] results = helloJNICpp.sumAndAverage(numbers);
//        System.out.println("In Java, the sum is " + results[0]);
//        System.out.println("In Java, the average is " + results[1]);
//
//        helloJNICpp.modifyInstanceVariable();
//        System.out.println("In Java, int is " + helloJNICpp.number);
//        System.out.println("In Java, String is " + helloJNICpp.message);
//
//        helloJNICpp.modifyStaticVariable();
//        System.out.println("In Java, the double is " + numberStatic);
//
//        helloJNICpp.nativeMethod();
//
//        System.out.println("In Java, the number is :" + helloJNICpp.getIntegerObject(9999));
    }
}