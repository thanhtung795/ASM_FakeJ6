package org.example.ps27852_lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.ps27852_lab8.entity.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Authority> authorities;

}
