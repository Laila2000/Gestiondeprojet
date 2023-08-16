package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Epic {
    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String description ;
    private String statute;
    @ManyToOne
    @JoinColumn(name = "id_projet")
    private projet projet;

    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
    private List<Tache> tasks = new ArrayList<>();


}
