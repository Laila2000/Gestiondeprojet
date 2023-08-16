package org.example.controller;

import org.example.Entity.Administrateur;
import org.example.services.Administrateurservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/administrateur")
public class AdministrateurController {
    @Autowired
    private Administrateurservice administrateurservice;

    @PostMapping
    public void createAdministratur(@RequestBody Administrateur administrateur) {
        administrateurservice.createAdministration(administrateur);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrateur(@PathVariable Long id) {
        administrateurservice.deleteAdministration(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur administrateur) {
        administrateurservice.updateAdministration(id, administrateur);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Administrateur> getAllAdmin() {
        return administrateurservice.getAlladministratuer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrateur> getAdministrateurById(@PathVariable Long id) {
        Optional<Administrateur> administrateur = administrateurservice.findOneBYId(id);
        if (administrateur.isPresent()) {
            return ResponseEntity.ok(administrateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }




    }
}
