package com.vlad.android.superhero;

public class SuperHero {

    private final String name;
    private final String imageUrl;

    public SuperHero(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
