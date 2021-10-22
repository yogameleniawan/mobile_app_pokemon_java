package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pokemon.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPokemon;
    private ArrayList<Pokemon> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPokemon = findViewById(R.id.rv_heroes);
        rvPokemon.setHasFixedSize(true);

        list.addAll(PokemonData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvPokemon.setLayoutManager(new LinearLayoutManager(this));
        ListPokemonAdapter listHeroAdapter = new ListPokemonAdapter(this,list);
        rvPokemon.setAdapter(listHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                break;

            case R.id.action_cardview:

                break;
        }
    }

    private void showRecyclerGrid(){
        rvPokemon.setLayoutManager(new GridLayoutManager(this, 2));
        GridPokemonAdapter gridPokemonAdapter = new GridPokemonAdapter(list);
        rvPokemon.setAdapter(gridPokemonAdapter);
    }
}