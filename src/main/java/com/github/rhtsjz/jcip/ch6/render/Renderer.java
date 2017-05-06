package com.github.rhtsjz.jcip.ch6.render;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by smile on 2017/3/11.
 */
public class Renderer {
    private static final long TIME_BUDGET = 100;
    private final ExecutorService executorService;

    public Renderer(ExecutorService executorService) {
        this.executorService = executorService;
    }

    void renderPage(CharSequence source) {
        List<ImageInfo> imageInfoList = scanForImageInfo(source);
        CompletionService<ImageData> completionService =
                new ExecutorCompletionService<ImageData>(executorService);
        for (final ImageInfo imageInfo : imageInfoList) {
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.dowanloadImage();
                }
            });
        }
        renderText(source);
        try {
            for (int t = 0, n = imageInfoList.size(); t < n; t++) {
                Future<ImageData> imageDataFuture = completionService.take();
                ImageData imageData = imageDataFuture.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw launderThrowable(e.getCause());
        }
    }

    /**
     * 如果 Throwable 是 Error, 那么抛出它；如果是 RuntimeException, 那么返回它，否则抛出 IllegalStateException
     */
    private RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalStateException("not unchecked", t);
        }
    }

    private void renderImage(ImageData imageData) {

    }

    private void renderText(CharSequence source) {

    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        return null;
    }
}
