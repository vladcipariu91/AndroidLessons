package com.vlad.android.superhero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(new SuperHero("BatMan", "https://webstockreview.net/images/joker-clipart-old-batman-cartoon.png"));
        superHeroes.add(new SuperHero("SuperMan", "https://i.pinimg.com/originals/ae/de/6b/aede6b4e8a2d5eedfca37f2a38770512.jpg"));
        superHeroes.add(new SuperHero("WonderWoman", "https://www.dccomics.com/sites/default/files/imce/2017/05-MAY/CN0105-009_2_f415d03b_592dfa3f349100.33226682.JPEG"));

        final SuperHeroAdapter adapter = new SuperHeroAdapter(superHeroes, new ItemClickListener() {
            @Override
            public void onItemClicked(int superHeroIndex) {
                final SuperHero superHero = superHeroes.get(superHeroIndex);
                Intent superHeroImageIntent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle extras = new Bundle();
                extras.putString(SecondActivity.KEY_IMAGE, superHero.getImageUrl());
                superHeroImageIntent.putExtras(extras);
                MainActivity.this.startActivity(superHeroImageIntent);
            }
        });

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}