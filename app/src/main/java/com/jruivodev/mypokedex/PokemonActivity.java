package com.jruivodev.mypokedex;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PokemonActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Pokemon>> {

    private PokemonAdapter mAdapter;
    private final static int POKEMON_LOADER = 1;
    private final static String POKEMON_URL = "http://pokeapi.co/api/v2/pokemon/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);


        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(POKEMON_LOADER, null, this);


        ListView listView = (ListView) findViewById(R.id.list_view);
        mAdapter = new PokemonAdapter(this, new ArrayList<Pokemon>());
        listView.setAdapter(mAdapter);

    }

    @Override
    public Loader<List<Pokemon>> onCreateLoader(int id, Bundle args) {
        return new PokemonLoader(this, POKEMON_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Pokemon>> loader, List<Pokemon> data) {
        mAdapter.clear();
        if (data != null && !data.isEmpty())
            mAdapter.addAll(data);

    }

    @Override
    public void onLoaderReset(Loader<List<Pokemon>> loader) {
        mAdapter.clear();
    }
}
