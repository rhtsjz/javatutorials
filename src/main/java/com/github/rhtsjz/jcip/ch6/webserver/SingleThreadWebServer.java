package com.github.rhtsjz.jcip.ch6.webserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by smile on 2017/3/5.
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        int port = 9000;
        ServerSocket socket = new ServerSocket(port);
        while (true){
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        InetAddress inetAddress = connection.getInetAddress();
        System.out.println(inetAddress.getHostAddress());
    }
}
