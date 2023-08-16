package org.example.services;

import org.example.Entity.Sprint;
import org.example.Entity.Tache;
import org.example.Entity.projet;
import org.example.Entity.security.Utilisateur;
import org.example.repository.TacheRepository;
import org.example.repository.security.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.NoSuchElementException;

public class Tacheservice {

    @Autowired
    private TacheRepository tacheRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Tache> getAllTache() {
        return tacheRepository.findAll();
    }



    public Tache createTask(Tache tache) {
        return tacheRepository.save(tache);
    }


    public List<Tache> getAllTasks() {
        return tacheRepository.findAll();
    }

    public Tache getTacheById(Long id) {
        return tacheRepository.findById(id).orElse(null);
    }

    public Tache updateTask(Long id, Tache updatedTask) {
        Tache existingTask = tacheRepository.findById(id).orElse(null);
        if (existingTask != null) {

            existingTask.setId(updatedTask.getId());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setTitre(updatedTask.getTitre());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setStatute(updatedTask.getTitre());

            return tacheRepository.save(existingTask);
        }
        return null;
    }

    public void deleteTask(Long id) {
        tacheRepository.deleteById(id);
    }


    public Tacheservice( TacheRepository tacheRepository, UtilisateurRepository userRepository) {
        this.tacheRepository = tacheRepository;
        this.utilisateurRepository = userRepository;
    }

    public void assignTaskToUser(Long taskId, Long userId) throws ChangeSetPersister.NotFoundException {
        Tache tache = tacheRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException("Tache not found"));
        Utilisateur user = utilisateurRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));

        tache.setUser(user);
        tacheRepository.save(tache);
    }
}








