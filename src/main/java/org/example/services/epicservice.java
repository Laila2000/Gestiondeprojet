package org.example.services;

import org.example.Entity.Epic;
import org.example.Entity.Tache;
import org.example.repository.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class epicservice    {
    @Autowired
    private EpicRepository epicRepository;
    public Epic createEpic(Epic epic) {

        return epicRepository.save(epic);
    }

    public List<Epic> getAllEpics() {
        return epicRepository.findAll();
    }

    public Epic getEpicById(Long id) {
        return epicRepository.findById(id).orElse(null);
    }
    public Epic updateEpic(Long id, Epic updatedEpic) {
        Epic existingEpic = epicRepository.findById(id).orElse(null);
        if (existingEpic != null) {
            existingEpic.setTitre(updatedEpic.getTitre());
            existingEpic.setDescription(updatedEpic.getDescription());
            existingEpic.setStatute(updatedEpic.getDescription());
            return epicRepository.save(existingEpic);
        }
        return null;
    }
    public void deleteEpic(Long id) {
        epicRepository.deleteById(id);
    }
    public Epic addTaskToEpic(Long epicId, Tache tache) {
        Epic epic = epicRepository.findById(epicId).orElse(null);
        if (epic != null) {

            tache.setEpic(epic);
            epic.getTasks().add(tache);
            return epicRepository.save(epic);

        }
        return null;
    }}


