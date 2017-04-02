package com.jruivodev.mypokedex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Jojih on 02/04/2017.
 */

public class PokemonAdapter extends ArrayAdapter<Pokemon> {


    public PokemonAdapter(Context context, List<Pokemon> pokemons) {
        super(context, 0, pokemons);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listRow = convertView;

        if (listRow == null) {
            listRow = LayoutInflater.from(getContext()).inflate(R.layout.pokemon_row, parent, false);
        }
        Pokemon currentPokemon = getItem(position);

        TextView nameView = (TextView) listRow.findViewById(R.id.name_view);
        nameView.setText(currentPokemon.getName());

// show The Image in a ImageView
        new DownloadImageTask((ImageView) listRow.findViewById(R.id.image_view))
                .execute(currentPokemon.getSpriteUrl());

        return listRow;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
