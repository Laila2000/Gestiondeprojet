package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Administrateur {
    @Id
    @GeneratedValue
    private Long id;

    private String nomAdmin;
    @OneToMany(mappedBy = "administration")
    private List<projet> projets;
}
