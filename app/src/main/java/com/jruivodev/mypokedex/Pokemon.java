package com.jruivodev.mypokedex;

/**
 * Created by Jojih on 02/04/2017.
 */

public class Pokemon {
    String mName;
    String mSpriteUrl;

    public Pokemon(String name, String spriteUrl) {
        mName = name;
        mSpriteUrl = spriteUrl;
    }

    public String getName() {
        return mName;
    }

    public String getSpriteUrl() {
        return mSpriteUrl;
    }
}
