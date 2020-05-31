package com.vlad.android.superhero;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vlad.android.superhero.async.Callback;
import com.vlad.android.superhero.async.GetBitmapTask;

import java.net.URL;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_IMAGE = "key_image";

    private View loader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        loader = findViewById(R.id.loader);

        final Intent intent = getIntent();
        if (intent.getExtras() != null) {
            final String superHeroImageUrl = intent.getExtras().getString(KEY_IMAGE);

            try {
                final URL url = new URL(superHeroImageUrl);
                loadBitmap(url);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    void loadBitmap(URL url) {
        final GetBitmapTask getBitmapTask = new GetBitmapTask(new Handler());
        getBitmapTask.execute(url, new Callback() {
            @Override
            public void onLoading() {
                loader.setVisibility(View.VISIBLE);
            }

            @Override
            public void onDone(Bitmap bitmap) {
                final ImageView superHeroImage = findViewById(R.id.super_hero_image);
                superHeroImage.setImageBitmap(bitmap);
                loader.setVisibility(View.GONE);
                superHeroImage.setVisibility(View.VISIBLE);
            }
        });
    }
}