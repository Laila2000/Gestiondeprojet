package org.example.services;

import org.example.Entity.Administrateur;
import org.example.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Administrateurservice {
    @Autowired
    private AdministrateurRepository administrationRepository;

    public void createAdministration(Administrateur administration) {
        administrationRepository.save( administration);
    }

    public void updateAdministration(Long id, Administrateur administrateur) {
        administrateur.setId(id);
        administrationRepository.save( administrateur);
    }

    public void deleteAdministration(Long id) {
        administrationRepository.deleteById(id);

    }
    public List<Administrateur> getAlladministratuer(){
       return administrationRepository.findAll();

    }
    public Optional<Administrateur> findOneBYId(Long id) {
        return administrationRepository.findById(id);
    }

}
