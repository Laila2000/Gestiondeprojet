package org.example.controller;

import org.example.Entity.Equipe;
import org.example.Entity.Tache;
import org.example.repository.EquipeRepository;
import org.example.services.equipeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Equipe")
public class EquipeController {
    @Autowired
    private equipeservice equipeservice;
    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        Equipe createEquipe=equipeservice.createEquipe(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEquipe);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe updatedEquipe) {
        Equipe equipe = equipeservice.updateEquipe(id, updatedEquipe);
        if (equipe != null) {
            return ResponseEntity.ok(equipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        equipeservice.deleteEquipe(id);
        return ResponseEntity.noContent().build();


    }
    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipe() {
        List<Equipe>equipe= equipeservice.getAllEquipe();
        return ResponseEntity.ok(equipe);
    }
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        Equipe equipe = org.example.services.equipeservice.getEquipeById(id);
        if (equipe != null) {
            return ResponseEntity.ok(equipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
