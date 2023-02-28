package com.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int  user_id;
    @Column
    private  String  user_name;
    @Column
    private String password;
    @Column
    private int role_id;
    @OneToMany(mappedBy = "user_id")
    private  List<TaskProgress> taskProgresses;
    public User(String user_name, String password, int role_id) {
        this.user_name = user_name;
        this.password = password;
        this.role_id = role_id;
    }
}
