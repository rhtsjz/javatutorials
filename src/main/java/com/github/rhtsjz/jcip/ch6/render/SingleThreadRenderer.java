package com.github.rhtsjz.jcip.ch6.render;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smile on 2017/3/3.
 */
public class SingleThreadRenderer {
    void renderPage(CharSequence source) throws Exception {
        renderText(source);
        List<ImageData> imageData = new ArrayList<ImageData>();
        for (ImageInfo imageInfo : scanForImageInfo(source)) {
            imageData.add(imageInfo.dowanloadImage());
        }
        for (ImageData data : imageData) {
            renderImage(data);
        }
    }

    void renderImage(ImageData data) {

    }

    List<ImageInfo> scanForImageInfo(CharSequence source) {
        return null;
    }

    void renderText(CharSequence source) {
        System.out.println("renderText");
    }
}
