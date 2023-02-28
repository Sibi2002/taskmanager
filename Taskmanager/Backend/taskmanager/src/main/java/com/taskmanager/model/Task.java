package com.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int task_id;
    @Column
    private String task_name;
    @OneToMany(mappedBy = "task_id")
    private List<TaskProgress> taskProgress;
}
