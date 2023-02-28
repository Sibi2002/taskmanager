package com.taskmanager.model;


import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "task_progress")
//@NamedNativeQuery(name = "TaskProgress.tasker",
//        query = "SELECT tasks.task_id ,task_name,users.user_name,due_date,assigned_date,a.user_name as admin ,over_due_by,task_progress.user_id from task_progress" +
//                " join users on users.user_id=task_progress.user_id join tasks on tasks.task_id = task_progress.task_id" +
//                " join users as a on a.user_id = task_progress.assigned_by where task_progress.user_id= ?1 and task_progress.status_id=19",
//        resultSetMapping = "Mapping.TaskProgressDto")
//@SqlResultSetMapping(name = "Mapping.TaskProgressDto",
//        classes = @ConstructorResult( targetClass = TaskProgressDto.class,
//                columns = {@ColumnResult(name = "task_id"),@ColumnResult(name = "task_name"),@ColumnResult(name = "user_id"),@ColumnResult(name = "user_name"),@ColumnResult(name = "admin"),@ColumnResult(name = "assigned_date"),@ColumnResult(name = "over_due_by"),
//                        @ColumnResult(name = "due_date") }))
public class TaskProgress {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    @Column(columnDefinition = "date default current_date")
    private Date assigned_date;
    @Column
    private Date due_date;
    @Column
    private int over_due_by;

    private int user_id;

    private int task_id;

    private int status_id;

    private int assigned_by;

    public TaskProgress(Date due_date, int user_id, int task_id, int assigned_by) {
        this.due_date = due_date;
        this.user_id = user_id;
        this.task_id = task_id;
        this.assigned_by = assigned_by;
    }
}
