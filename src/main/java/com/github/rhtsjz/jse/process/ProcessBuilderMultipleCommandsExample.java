package com.github.rhtsjz.jse.process;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by smile on 2017/8/5.
 */
public class ProcessBuilderMultipleCommandsExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        // multiple commands
        // /C Carries out the command specified by string and then terminates
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("echo", "This is ProcessBuilder Example from JCG");
        pb.directory(new File("src"));

        Process process = pb.start();
        IOThreadHandler outputHandler = new IOThreadHandler(
                process.getInputStream());
        outputHandler.start();
        process.waitFor();
        outputHandler.join();
        System.out.println(outputHandler.getOutput());

    }

    private static class IOThreadHandler extends Thread {
        private InputStream inputStream;
        private StringBuilder output = new StringBuilder();

        public IOThreadHandler(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            Scanner br = null;
            br = new Scanner(new InputStreamReader(inputStream));
            String line = null;
            while (br.hasNextLine()) {
                line = br.nextLine();
                output.append(line
                        + System.getProperty("line.separator"));
            }
            br.close();
        }

        public StringBuilder getOutput() {
            return output;
        }
    }
}
