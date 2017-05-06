package com.github.rhtsjz.jcip.ch6.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/**
 * Created by smile on 2017/3/9.
 */
public class LifecycleWebServer {
    Logger log = Logger.getLogger(LifecycleWebServer.class.getSimpleName());

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(8000);
        while (!executorService.isShutdown()) {
            try {
                final Socket connection = socket.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(connection);
                    }
                };
                executorService.execute(task);
            } catch (RejectedExecutionException e) {
                if (!executorService.isShutdown()) {
                    e.printStackTrace();
                    log.info("task submission rejected");
                }
            }
        }
    }

    public void stop() {
        executorService.shutdown();
    }

    private void handleRequest(Socket connection) {
        Request req = readRequest(connection);
        if (isShutdownRequest(req)) {
            stop();
        } else {
            dispatchRequest(req);
        }

    }

    private void dispatchRequest(Request req) {

    }

    private boolean isShutdownRequest(Request req) {
        return false;
    }

    private Request readRequest(Socket connection) {
        return null;
    }

    private class Request {
    }
}
