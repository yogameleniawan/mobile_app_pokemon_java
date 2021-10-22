package com.example.pokemon;

import java.util.ArrayList;

public class PokemonData {

    private static String[] pokemonNames = {
            "Bulbasaur",
            "Ivysaur",
            "Venusaur",
            "Charmander",
            "Charmeleon",
            "Charizard",
            "Squirtle",
            "Wartortle",
            "Blastoise"
    };

    private static String[] pokemonDetails = {
            "Type : Grass and Poison",
            "Type : Grass and Poison",
            "Type : Grass and Poison",
            "Type : Fire",
            "Type : Fire",
            "Type : Fire and Flying",
            "Type : Water",
            "Type : Water",
            "Type : Water",
    };

    private static int[] pokemonImages = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
    };

    static ArrayList<Pokemon> getListData() {
        ArrayList<Pokemon> list = new ArrayList<>();
        for (int position = 0; position < pokemonNames.length; position++) {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(pokemonNames[position]);
            pokemon.setDetail(pokemonDetails[position]);
            pokemon.setPhoto(pokemonImages[position]);
            list.add(pokemon);
        }
        return list;
    }

}

