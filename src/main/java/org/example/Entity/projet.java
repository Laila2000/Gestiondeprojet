package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Entity.security.Utilisateur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class projet {
    @Id
    @GeneratedValue

    private Long Id;
    private  String nom ;
    private String description;
    private String  date_debut ;
    private String date_fin;
    private String statute;
    @ManyToMany(mappedBy = "projets")
    private Set<Utilisateur> utilisateurs = new HashSet<>();

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Epic> epics = new ArrayList<>();

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tache> taches = new ArrayList<>();

    ;
    @ManyToOne
    @JoinColumn(name = "administration_id")
    private Administrateur administration;


}
