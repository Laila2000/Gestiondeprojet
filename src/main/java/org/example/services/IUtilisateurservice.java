package org.example.services;


import org.example.Entity.security.Utilisateur;

import java.util.List;

public interface IUtilisateurservice {
    List<Utilisateur>getAllUsers();
    boolean existsByEmail(String email);
    boolean existsByUsername (String nom);

    void saveUser(Utilisateur user);

    void DeleteUser(Long id);

    Utilisateur UpdateUser(Long id ,Utilisateur utilisateur);

    List<Utilisateur> findAllUser ();

    Utilisateur findOneBYId (Long id);
    List <Utilisateur>findByEmail(String email);

}
