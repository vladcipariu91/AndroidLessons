package com.vlad.android.superhero.async;

import android.graphics.Bitmap;

public interface Callback {

    void onLoading();
    void onDone(Bitmap bitmap);
}
