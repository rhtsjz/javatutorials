package com.github.rhtsjz.jse.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by smile on 2017/8/5.
 */
public class ProcessBuilderExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("echo", "This is ProcessBuilder Example from JCG");
        System.out.println("Run echo command");
        Process p = pb.start();
        int errCode = p.waitFor();
        System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
//        InputStream errorStream = p.getErrorStream();
        InputStream inputStream = p.getInputStream();
        System.out.println("Echo Output:\n" + parseInput(inputStream));
//        System.out.println("errorStream" + parseInput(errorStream));

    }

    private static String parseInput(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + System.getProperty("line.separator"));
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
