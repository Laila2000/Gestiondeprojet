package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Commentaire {
    @Id
    @GeneratedValue

    private Long id;
    private  String content;
    private String date_creation;
    private String auteur;

    @ManyToMany
    @JoinTable(name = "equipe_commentaire",
            joinColumns = @JoinColumn(name = "id_equip"),
            inverseJoinColumns = @JoinColumn(name = "id_commentaire"))
    private Set<Equipe> equipes = new HashSet<>();

}
