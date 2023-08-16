package org.example.services;

import org.example.Entity.Sprint;
import org.example.Entity.projet;
import org.example.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class springservice {
    @Autowired
    private SprintRepository sprintRepository;

    public Sprint createSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    public void deleteSprint(Long id) {
        sprintRepository.deleteById(id);
    }

    public void updateSprint(Long id, Sprint sprint) {
        Sprint existingSprint = sprintRepository.findById(id).orElse(null);
        if (existingSprint != null) {
            sprint.setId(id);
            sprint.setNom(sprint.getNom());
            sprint.setObjective(sprint.getObjective());
            sprint.setDate_debut(sprint.getDate_debut());
            sprint.setDate_fin((sprint.getDate_fin()));
            sprint.setStatute(sprint.getStatute());

            sprintRepository.save(sprint);
        }
    }
    public List<Sprint> getAllSprint() {
        return sprintRepository.findAll();
    }
    public Sprint getSprintById(Long id) {
        return sprintRepository.findById(id).orElse(null);
    }
}
