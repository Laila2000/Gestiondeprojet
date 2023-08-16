package org.example.controller;

import org.example.Entity.Sprint;
import org.example.Entity.projet;
import org.example.services.springservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("Sprints")
public class SprintController {
    @Autowired
    private springservice springservice;
    public ResponseEntity<Sprint> createProjet(@RequestBody Sprint sprint) {
        springservice.createSprint(sprint);
        return ResponseEntity.status(HttpStatus.CREATED).body(sprint);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Sprint> updateProjet(@PathVariable Long id, @RequestBody Sprint sprint) {
        springservice.updateSprint(id, sprint);
        return ResponseEntity.ok(sprint);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        springservice.deleteSprint(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Sprint>> getAllSprints() {
        List<Sprint> sprints = springservice.getAllSprint();
        return ResponseEntity.ok(sprints);
    }
    public ResponseEntity<Sprint> getProjetById(@PathVariable Long id) {
        Sprint sprint = springservice.getSprintById(id);
        if (sprint != null) {
            return ResponseEntity.ok(sprint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
