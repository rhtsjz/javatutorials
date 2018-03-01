package com.github.rhtsjz.graphics2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

public class WriteImageType {
    public static void main(String[] argv) throws Exception {
        int width = 865;
        int height = 650;

        long start = System.currentTimeMillis();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        double[] points = {159.33241271973, 282.30056762695, 256.35604858398, 260.92764282227, 260.80667114258, 291.20593261719};
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(10));
        if (points.length >= 4) {
            for (int i = 0; i < points.length / 2 - 1; i++) {
                g2d.draw(new Line2D.Double(points[2 * i], points[2 * i + 1], points[2 * (i + 1)], points[2 * (i + 1) + 1]));
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        g2d.dispose();
        System.out.println(System.currentTimeMillis() - start);
        RenderedImage rendImage = bufferedImage;

        System.out.println(System.currentTimeMillis() - start);
        File file = new File("newimage.png");

        System.out.println(System.currentTimeMillis() - start);
        ImageIO.write(rendImage, "png", file);
        System.out.println(System.currentTimeMillis() - start);

    }

}
