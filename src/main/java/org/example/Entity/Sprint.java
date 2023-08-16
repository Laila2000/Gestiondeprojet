package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Sprint {
    @Id
    @GeneratedValue

    private Long id;
    private String nom;
    private String objective ;
    private String  date_debut ;
    private String date_fin;
    private String statute;

    @ManyToMany
    @JoinTable(name = "sprint_Tache",
            joinColumns = @JoinColumn(name = "id_sprint"),
            inverseJoinColumns = @JoinColumn(name = "id_tache"))
    private Set<Tache> taches = new HashSet<>();

    @ManyToMany(mappedBy = "sprints")
    private Set<Equipe> equipes = new HashSet<>();


}
