package com.github.rhtsjz.jcip.ch6.render;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by smile on 2017/3/3.
 */
public class FutureRenderer extends SingleThreadRenderer {
    private final ExecutorService executor = null;

    void renderPage(CharSequence source) throws Exception {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task =
                new Callable<List<ImageData>>() {
                    @Override
                    public List<ImageData> call() throws Exception {
                        List<ImageData> result = new ArrayList<>();
                        for (ImageInfo imageInfo : imageInfos) {
                            result.add(imageInfo.dowanloadImage());
                        }
                        return result;
                    }
                };

        Future<List<ImageData>> future = executor.submit(task);
        renderText(source);

        try {
            List<ImageData> imageDatas = future.get();
            for (ImageData imageData: imageDatas){
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            // 重新设置线程的中断状态
            Thread.currentThread().interrupt();
            // 由于不需要结果，因此取消任务
            future.cancel(true);
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw launderThrowable(e.getCause());
        }
    }

    private Exception launderThrowable(Throwable cause) {
        return null;
    }
}
