package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Equipe {
    @Id
    @GeneratedValue

    private Long id ;
    private String nom;

    private String role;

    @ManyToMany
    @JoinTable(name = "equipe_sprint",
            joinColumns = @JoinColumn(name = "id_equip"),
            inverseJoinColumns = @JoinColumn(name = "id_sprint"))
    private Set<Sprint> sprints = new HashSet<>();


    @ManyToMany(mappedBy = "equipes")
    private Set<Commentaire> commentaires = new HashSet<>();


}
