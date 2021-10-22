package com.example.pokemon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridPokemonAdapter extends RecyclerView.Adapter<GridPokemonAdapter.GridViewHolder> {
    private ArrayList<Pokemon> listPokemon;

    public GridPokemonAdapter(ArrayList<Pokemon> list) {
        this.listPokemon = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_pokedex, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Pokemon pokemon = listPokemon.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listPokemon.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.txtName.setText(pokemon.getName());
    }

    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView txtName;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            txtName = itemView.findViewById(R.id.txt_name);
        }
    }
}
