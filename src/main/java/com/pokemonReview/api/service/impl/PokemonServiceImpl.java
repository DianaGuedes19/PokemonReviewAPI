package com.pokemonReview.api.service.impl;

import com.pokemonReview.api.DTO.PokemonDTO;
import com.pokemonReview.api.models.Pokemon;
import com.pokemonReview.api.repository.PokemonRepository;
import com.pokemonReview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired // Aqui é que deve vir o autowired e não acima
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    // Com o erro a criar a classe pede logo para fazer o este metodo
    @Override
    public PokemonDTO createPokemon(PokemonDTO pokemonDTO) {

        // Aqui estamos a criar um novo pokemon e a atribuir os dados do objeto criado acima com DTO
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());

        // Aqui estamos a salvar o pokemon no respositório
        Pokemon newPokemon = pokemonRepository.save(pokemon);

        // Aqui estamos a dar como resposta um PokemonDTO para garantir a separação do que acontece internamente no sistema e o que é passado ao user.
        PokemonDTO pokemonResponse = new PokemonDTO();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());

        return pokemonResponse;

    }

    @Override
    public List<PokemonDTO> getAllPokemon() {
        List <Pokemon> pokemon = pokemonRepository.findAll();
        return pokemon.stream().map(p -> mapToDTO(p)).collect(Collectors.toList());
    }


    // Mapping para depois não ter que adicionar isto na lista
    PokemonDTO mapToDTO (Pokemon pokemon){
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setType(pokemon.getType());
        return pokemonDTO;
    }

    Pokemon mapToEntity (PokemonDTO pokemonDTO){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());
        return pokemon;
    }
}
