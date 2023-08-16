package org.example.controller;

import org.example.Entity.projet;
import org.example.services.projetservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/projets")

public class projetController {
    @Autowired

    private projetservice projetservice;
    @PostMapping("/AjoutUser")
    public ResponseEntity<projet> createProjet(@RequestBody projet projet) {
        projetservice.createProjet(projet);
        return ResponseEntity.status(HttpStatus.CREATED).body(projet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetservice.deleteProjet(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<projet> updateProjet(@PathVariable Long id, @RequestBody projet projet) {
        projetservice.updateProjet(id, projet);
        return ResponseEntity.ok(projet);
    }
    @GetMapping
    public ResponseEntity<List<projet>> getAllProjects() {
        List<projet> projects = projetservice.getAllProjects();
        return ResponseEntity.ok(projects);
    }
    public ResponseEntity<projet> getProjetById(@PathVariable Long id) {
        projet projet = projetservice.getProjectById(id);
        if (projet != null) {
            return ResponseEntity.ok(projet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
