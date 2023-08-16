package org.example.services;

import org.example.Entity.Equipe;
import org.example.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class equipeservice {
    @Autowired
    private static EquipeRepository equipeRepository;

    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    public Equipe updateEquipe(Long id, Equipe equipe) {
        Equipe existingEquipe = equipeRepository.findById(id).orElse(null);
        if (existingEquipe != null) {
            existingEquipe.setNom(equipe.getNom());
            existingEquipe.setRole(equipe.getRole());

            equipeRepository.save(existingEquipe);
        }
        return existingEquipe;
    }
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    public static Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    }

