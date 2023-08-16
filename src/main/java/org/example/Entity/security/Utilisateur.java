package org.example.Entity.security;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.Entity.Tache;
import org.example.Entity.projet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name= "users",
        uniqueConstraints = {
@UniqueConstraint (columnNames="nom"),
@UniqueConstraint( columnNames="email")})
@Data

public class Utilisateur {
@Id
@GeneratedValue (strategy =GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  @Size(max=50)
  private String nom;
  @NotBlank
  @Size(max=50)
  private String Email;
  @NotBlank
  @Size(max=120)
  private  String mdp;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable (name  ="user_roles",
  joinColumns =@JoinColumn(name="user_id"),
          inverseJoinColumns = @JoinColumn(name="role_id"))
  private  Set<Role>roles=new HashSet<>();


  @ManyToMany
  @JoinTable(name = "utilisateur_projet",
          joinColumns = @JoinColumn(name = "utilisateur_id"),
          inverseJoinColumns = @JoinColumn(name = "projet_id"))
  private Set<projet> projets = new HashSet<>();

  @OneToMany(mappedBy = "user")
  private List<Tache> teaches;


}
