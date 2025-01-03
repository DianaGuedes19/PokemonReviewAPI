package com.pokemonReview.api.service;

import com.pokemonReview.api.DTO.PokemonDTO;

import java.util.List;

public interface PokemonService {
    PokemonDTO createPokemon (PokemonDTO pokemonDTO);
    List<PokemonDTO> getAllPokemon();
}
