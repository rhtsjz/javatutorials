package com.github.rhtsjz.jse.process;

import java.io.IOException;

/**
 * Created by smile on 2017/8/5.
 */
public class ProcessBuilderInheritIOExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("echo", "Hello JCG\nThis is ProcessBuilder Example");
        pb.inheritIO();
        System.out.println("Run Echo command with inheritIO set");
        Process process = pb.start();
        process.waitFor();


    }
}
