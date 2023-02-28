package com.taskmanager.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
public class TaskAssignDto {

    private String user_name;
    private String assigned_by;
    private int task_id;
    private Date due_date;
}
