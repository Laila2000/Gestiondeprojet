package org.example.controller;

import org.example.Entity.Epic;
import org.example.Entity.Sprint;
import org.example.services.epicservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Epic")
public class EpicController {
    @Autowired
    private epicservice epicservice;
    public ResponseEntity<Epic> createEpic(@RequestBody Epic epic) {
        epicservice.createEpic(epic);
        return ResponseEntity.status(HttpStatus.CREATED).body(epic);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Epic> updateEpic(@PathVariable Long id, @RequestBody Epic epic) {
        epicservice.updateEpic(id, epic);
        return ResponseEntity.ok(epic);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpic(@PathVariable Long id) {
        epicservice.deleteEpic(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Epic>> getAllEpics() {
        List<Epic> Epics = epicservice.getAllEpics();
        return ResponseEntity.ok(Epics);
    }
    public ResponseEntity<Epic> getEpicById(@PathVariable Long id) {
        Epic epic = epicservice.getEpicById(id);
        if (epic != null) {
            return ResponseEntity.ok(epic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


