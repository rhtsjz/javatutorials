package com.github.rhtsjz.jcip.ch6.webserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by smile on 2017/3/9.
 */
public class TaskExecutionWebServer {
    public static final int nthreads = 100;
    public static final Executor exec
            = Executors.newFixedThreadPool(nthreads);
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSocket socket = new ServerSocket(port);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
        InetAddress inetAddress = connection.getInetAddress();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(count++);
    }
}
