package com.vlad.android.superhero;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SuperHeroViewHolder extends RecyclerView.ViewHolder {

    private TextView superHeroName;
    private final ItemClickListener itemClickListener;

    public SuperHeroViewHolder(@NonNull View itemView,
                               ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        superHeroName = itemView.findViewById(R.id.super_hero_name);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SuperHeroViewHolder.this.itemClickListener.onItemClicked(getAdapterPosition());
            }
        });
    }

    public void setName(String name) {
        superHeroName.setText(name);
    }
}
