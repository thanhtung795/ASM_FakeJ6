package org.example.ps27852_lab8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Username", "Roleid"})
})
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Username")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "Roleid")
    private Role role;
}