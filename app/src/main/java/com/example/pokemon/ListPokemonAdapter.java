package com.example.pokemon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPokemonAdapter extends RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder> {
    private ArrayList<Pokemon> listPokemon;
    private final Context mContext;

    public ListPokemonAdapter(Context context, ArrayList<Pokemon> list) {
        this.listPokemon = list;
        mContext = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_pokedex, viewGroup, false);
        return new ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Pokemon pokemon = listPokemon.get(position);
        Glide.with(holder.itemView.getContext())
                .load(pokemon.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(pokemon.getName());
        holder.tvDetail.setText(pokemon.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listPokemon.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
//                if(listPokemon.get(holder.getAdapterPosition()).getName().equals("Bulbasaur")){
//                    Intent intent= new Intent(context, DetailActivity.class);
//                    context.startActivity(intent);
//                }

//                else if(listPokemon.get(position).equals("Germany")){
//                    Intent intent= new Intent(context, DetailActivity.class);
//                    context.startActivity(intent);
//                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgPhoto;
        TextView tvName, tvDetail;
        LinearLayout parentLayout;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Pokemon data);
    }
}
