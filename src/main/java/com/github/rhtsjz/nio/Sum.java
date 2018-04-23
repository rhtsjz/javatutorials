package com.github.rhtsjz.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Sum {

    private static int sum(ByteBuffer bb) {
        int sum = 0;
        while (bb.hasRemaining()) {
            if ((sum & 1) != 0) {
                sum = (sum >> 1) + 0x8000;
            } else {
                sum >>= 1;
            }
            sum += bb.get() & 0xff;
            sum &= 0xffff;
        }
        return sum;
    }

    private static void sum(File f) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        FileChannel fc = fis.getChannel();

        long sz = fc.size();
        MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, sz);

        int sum = sum(bb);

        long kb = (sz + 1023) / 1024;
        String s = Integer.toString(sum);
        System.out.println(s + "\t" + kb + "\t" + f);

        fc.close();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Sum file...");
            return;
        }

        for (int i=0; i< args.length;i++){
            File f = new File(args[i]);
            try {
                sum(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
