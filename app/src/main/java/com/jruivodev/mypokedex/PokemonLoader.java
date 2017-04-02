package com.jruivodev.mypokedex;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Jojih on 02/04/2017.
 */

public class PokemonLoader extends AsyncTaskLoader<List<Pokemon>> {

    private String mUrl;

    public PokemonLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Pokemon> loadInBackground() {
        if (mUrl == null)
            return null;
        List<Pokemon> pokemons = QueryUtils.fetchPokemonData(mUrl);
        Log.e("SOME LOG:", "HEY IM HEEEEEEEEERE #####################################");

        return pokemons;
    }
}
