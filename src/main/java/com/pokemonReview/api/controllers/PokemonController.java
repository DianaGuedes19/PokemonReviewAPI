package com.pokemonReview.api.controllers;

import com.pokemonReview.api.models.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // Informamos que esta class é um controller
@RequestMapping("/api/") // Vamos  ter entre o nosso URL o "api"
public class PokemonController {

    @GetMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)// Vai ser o request de Get
    public Pokemon pokemonById (@PathVariable int id){
        return new Pokemon(id,"Pikachu","Eletric");
    }

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pokemon> createPokemon (@RequestBody Pokemon pokemon){
        return new ResponseEntity<>(pokemon,HttpStatus.CREATED);
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
