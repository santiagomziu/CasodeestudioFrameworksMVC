package com.iudigital.rollerSpeed.model;

import com.iudigital.rollerSpeed.model.enums.RolesList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @SequenceGenerator(
            name = "roles_seq",
            sequenceName = "roles_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "name" , nullable = false,unique = true )
    @Enumerated(EnumType.STRING)
    private RolesList name;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    private List<User> users;
}
