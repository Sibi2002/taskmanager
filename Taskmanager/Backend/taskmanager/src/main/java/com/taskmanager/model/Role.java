package com.taskmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    @Column
    private  String role_name;
    @OneToMany(mappedBy = "role_id")
    private List<User> user;
}
