package org.example.services;

import org.example.Entity.projet;
import org.example.repository.projetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class projetservice  {
    @Autowired

    private projetRepository projetRepository;
    public  void  createProjet (projet projet){
        projetRepository.save(projet); }

    public  void  updateProjet (Long id ,projet projet){
        projet existingProject = projetRepository.findById(id).orElse(null);
        if (existingProject != null){
        projet.setId(id);
        projet.setNom(projet.getNom());
        projet.setDescription(projet.getDescription());
        projet.setDate_debut(projet.getDate_debut());
        projet.setDate_fin((projet.getDate_fin()));

        projetRepository.save(projet);}

    }

    public  void deleteProjet (Long id){
        projetRepository.deleteById(id);
    }
    public List<projet> getAllProjects() {
        return projetRepository.findAll();
    }
    public projet getProjectById(Long id) {
        return projetRepository.findById(id).orElse(null);
    }


    }


