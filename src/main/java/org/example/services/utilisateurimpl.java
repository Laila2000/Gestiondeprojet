package org.example.services;

import org.example.Entity.Administrateur;
import org.example.Entity.security.ERole;
import org.example.Entity.security.Role;
import org.example.Entity.security.Utilisateur;
import org.example.repository.security.RolesRepository;
import org.example.repository.security.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class utilisateurimpl implements  IUtilisateurservice {
    @Autowired
    private UtilisateurRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public  List<Utilisateur>getAllUsers(){return  userRepository.getAllUsers();}
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public boolean existsByUsername(String nom) {
        return userRepository.existsByUsername(nom);
    }


    @Override
    public List<Utilisateur> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Utilisateur utilisateur) {
        Set<Role> roles = new HashSet<>();
        roles.add(rolesRepository.findByIName(ERole.ROLE_USER).get());
        utilisateur.setRoles((roles));
        userRepository.save(utilisateur);

    }

    @Override
    public void DeleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Utilisateur UpdateUser(Long id, Utilisateur utilisateur) {
        utilisateur.setId(id);
        utilisateur.setNom(utilisateur.getNom());
        utilisateur.setEmail(utilisateur.getEmail());
        utilisateur.setMdp(utilisateur.getMdp());
           return  userRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> findAllUser() {
        return null;
    }

    @Override
    public Utilisateur findOneBYId(Long id) {
        return userRepository.findById(id).orElse(null);
    }



}
