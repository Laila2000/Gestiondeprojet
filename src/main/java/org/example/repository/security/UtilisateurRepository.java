package org.example.repository.security;

import org.example.Entity.security.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional <Utilisateur> findByname(String  nom);
    Boolean existsByUsername (String nom);
    Boolean existsByEmail (String email);

    @Query("select u from user u where u.email= ?1")
    List<Utilisateur>findByEmail(String email);

    List<Utilisateur> getAllUsers();
}
