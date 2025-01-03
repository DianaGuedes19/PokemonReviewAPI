package com.pokemonReview.api.controllers;

import com.pokemonReview.api.DTO.PokemonDTO;
import com.pokemonReview.api.models.Pokemon;
import com.pokemonReview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // Informamos que esta class é um controller
@RequestMapping("/api/") // Vamos  ter entre o nosso URL o "api"
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    @ResponseStatus(HttpStatus.OK)// Vai passar o estado do HTTP
    public ResponseEntity<List<PokemonDTO>> SeeAllPokemons (){
        return new ResponseEntity<>(pokemonService.getAllPokemon(),HttpStatus.OK);
    }

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDTO> createPokemon (@RequestBody PokemonDTO pokemonDTO){
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDTO), HttpStatus.CREATED);
    }

    @PutMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Pokemon> updatePokemon (@RequestBody Pokemon pokemon, @PathVariable ("id") int pokemonId){
        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePokemon ( @PathVariable ("id") int pokemonId){
        return ResponseEntity.ok("Pokemon Deleted");
    }
}
