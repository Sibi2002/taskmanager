package com.taskmanager.dto;

import java.util.Date;

public interface AssignedTaskDto {
    int getId();
    int getTask_id();
    String getTask_name();

    String getAdmin_name();
    Date getAssigned_date();
    Date getDue_date();
    Date getCompleted_date();
    int getOver_due_by();
}
