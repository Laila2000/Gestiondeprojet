package org.example.controller;

import org.example.Entity.Sprint;
import org.example.Entity.Tache;
import org.example.repository.TacheRepository;
import org.example.services.Tacheservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Taches")
public class TacheController {
    @Autowired
    private Tacheservice tacheservice;
    @PostMapping
    public ResponseEntity<Tache> createTache(@RequestBody Tache tache) {
        Tache createTask = tacheservice.createTask(tache);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTask);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tache> updateTache(@PathVariable Long id, @RequestBody Tache updatedTache) {
        Tache tache = tacheservice.updateTask(id, updatedTache);
        if (tache != null) {
            return ResponseEntity.ok(tache);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        tacheservice.deleteTask(id);
        return ResponseEntity.noContent().build();


    }
    @GetMapping
    public ResponseEntity<List<Tache>> getAllTache() {
        List<Tache>taches= tacheservice.getAllTache();
        return ResponseEntity.ok(taches);
    }
    public ResponseEntity<Tache> getTacheById(@PathVariable Long id) {
        Tache tache = tacheservice.getTacheById(id);
        if (tache != null) {
            return ResponseEntity.ok(tache);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
