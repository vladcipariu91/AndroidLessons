package com.vlad.android.superhero.async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetBitmapTask {

    private final Handler uiHandler;

    public GetBitmapTask(Handler uiHandler) {
        this.uiHandler = uiHandler;
    }

    public void execute(final URL url, final Callback callback) {
        callback.onLoading();
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = getBitmap(url);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onDone(bitmap);
                    }
                });
            }
        });
    }

    private Bitmap getBitmap(final URL url) {
        try (InputStream inputStream = url.openConnection().getInputStream()) {
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
