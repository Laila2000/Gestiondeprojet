package org.example.services;

import org.example.Entity.Commentaire;
import org.example.Entity.projet;
import org.example.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentaireservice {
    @Autowired
    private CommentaireRepository commentaireRepository;


    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public void deleteById(Long id) {
        commentaireRepository.deleteById(id);
    }


    public Commentaire updateById(Long id, Commentaire commentaire) {
        Commentaire existingcommentaire = commentaireRepository.findById(id).orElse(null);
        if (existingcommentaire != null) {
            commentaire.setId(id);
            commentaire.setAuteur(commentaire.getAuteur());
            commentaire.setContent(commentaire.getContent());
            commentaire.setDate_creation((commentaire.getDate_creation()));

            commentaireRepository.save(commentaire);
        }


        return null;
    }


    public List<Commentaire> getAllCommentaire() {
        return commentaireRepository.findAll();
    }

    public Commentaire getCommentaireById(Long id) {
        return commentaireRepository.findById(id).orElse(null);
    }
}
