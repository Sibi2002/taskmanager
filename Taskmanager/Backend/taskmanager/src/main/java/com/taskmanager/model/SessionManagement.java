package com.taskmanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
@Entity(name = "session_management")
@Setter
@Getter
public class SessionManagement {
    @Id
    private UUID id;
    private int user_id;
    private int role_id;

    private String user_name;

}
