package org.example.controller;

import org.example.Entity.Commentaire;
import org.example.Entity.Tache;
import org.example.services.commentaireservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/commentaire")
public class CommentaireController {
    @Autowired
    private commentaireservice commentaireservice;

    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire createCommentaire = commentaireservice.createCommentaire(commentaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCommentaire);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire updateCommentaire) {
        Commentaire commentaire = commentaireservice.updateById(id, updateCommentaire);
        if (commentaire != null) {
            return ResponseEntity.ok(commentaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
