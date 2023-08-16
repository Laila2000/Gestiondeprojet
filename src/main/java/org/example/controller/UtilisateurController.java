package org.example.controller;


import org.example.Entity.security.Utilisateur;
import org.example.services.utilisateurimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private utilisateurimpl utilisateurService;

    @PostMapping("/register")

    public ResponseEntity<Utilisateur> registerUser(@RequestBody Utilisateur utilisateur) {
        if (utilisateurService.existsByEmail(utilisateur.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Email already exists
        }

        if (utilisateurService.existsByUsername(utilisateur.getNom())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Username already exists
        }

        utilisateurService.saveUser(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateur);
    }

     @GetMapping("/utilisateur")

     public List<Utilisateur>getAllUsers(){
        List<Utilisateur>list=utilisateurService.getAllUsers();
        return  list;
     }
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.findOneBYId(id);
        if (utilisateur != null) {
            return ResponseEntity.ok(utilisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.findOneBYId(id);
        if (utilisateur != null) {
            utilisateurService.DeleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> UpdateUser(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur existingUtilisateur = utilisateurService.findOneBYId(id);
        if (existingUtilisateur != null) {
            utilisateur.setId(id);
            Utilisateur updatedUtilisateur = utilisateurService.UpdateUser(id,




                    utilisateur);
            return ResponseEntity.ok(updatedUtilisateur);
        } else {
            return ResponseEntity.notFound().build();

        }
    }

}
