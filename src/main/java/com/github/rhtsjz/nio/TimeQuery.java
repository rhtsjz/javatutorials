package com.github.rhtsjz.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class TimeQuery {
    // The standard daytime port
    private static int DAYTIME_PORT = 13;

    // The port we'll actually use
    private static int port = DAYTIME_PORT;

    // Charset and decoder for US-ASCII
    private static Charset charset = Charset.forName("US-ASCII");
    private static CharsetDecoder decoder = charset.newDecoder();

    // Direct byte buffer for reading
    private static ByteBuffer dbuf = ByteBuffer.allocateDirect(1024);

    // Ask the given host what time it is
    private static void query(String host) throws IOException {

    }
}
