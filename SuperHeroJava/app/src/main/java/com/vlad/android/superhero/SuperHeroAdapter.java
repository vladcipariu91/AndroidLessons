package com.vlad.android.superhero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroViewHolder> {

    private List<SuperHero> superHeroes;
    private ItemClickListener itemClickListener;

    public SuperHeroAdapter(List<SuperHero> superHeroes, ItemClickListener itemClickListener) {
        this.superHeroes = superHeroes;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SuperHeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_super_hero, parent, false);
        return new SuperHeroViewHolder(itemView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroViewHolder holder, int position) {
        final SuperHero superHero = superHeroes.get(position);
        holder.setName(superHero.getName());
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }
}
