package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Entity.security.Utilisateur;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Tache {
    @Id
    @GeneratedValue
    private long id;
    private String titre ;
    private String description ;
    private String statute ;
    private String priority;
    private String signed;
    @ManyToOne
    @JoinColumn(name = "id_projet")
    private projet projet;

    @ManyToOne
    @JoinColumn(name="id_user")
    private Utilisateur user;


    @ManyToMany(mappedBy = "taches")
    private Set<Sprint> sprints = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "epic_id")
    private Epic epic;


}
