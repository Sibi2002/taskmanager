package com.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "status")
public class Status {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int status_id;
    @Column
    private String status_name;
    @OneToMany(mappedBy = "status_id")
    private List<TaskProgress> taskProgress;
}
