package com.taskmanager.repository;
import com.taskmanager.dto.AssignedTaskDto;
import com.taskmanager.dto.TaskAssignDto;
import com.taskmanager.model.TaskProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskProgressRepository extends JpaRepository<TaskProgress,Integer> {

     @Query(value = "SELECT id,tasks.task_id ,task_name , a.user_name as admin_name ,assigned_date ,due_date, over_due_by,cast(task_progress.updated_on as date)  as completed_date from task_progress" +
                       " join users on users.user_id=task_progress.user_id join tasks on tasks.task_id = task_progress.task_id" +
                       " join users as a on a.user_id = task_progress.assigned_by where task_progress.user_id= ?1 and task_progress.status_id=1",nativeQuery = true)
     List<AssignedTaskDto> getAssignedTask(int user_id);

     @Query(value = "SELECT id,tasks.task_id ,task_name , a.user_name as admin_name ,assigned_date ,due_date, over_due_by, cast(task_progress.updated_on as date)  as completed_date from task_progress" +
            " join users on users.user_id=task_progress.user_id join tasks on tasks.task_id = task_progress.task_id" +
            " join users as a on a.user_id = task_progress.assigned_by where task_progress.user_id= ?1 and task_progress.status_id=2",nativeQuery = true)

      List<AssignedTaskDto> getCompletedTask(int user_id);
     @Query(value = "SELECT id,tasks.task_id ,task_name , a.user_name as admin_name ,assigned_date ,due_date, over_due_by, cast(task_progress.updated_on as date)  as completed_date from task_progress" +
            " join users on users.user_id=task_progress.user_id join tasks on tasks.task_id = task_progress.task_id" +
            " join users as a on a.user_id = task_progress.assigned_by where task_progress.user_id= ?1 and task_progress.status_id=3",nativeQuery = true)

     List<AssignedTaskDto> getOverDueTask(int user_id);
     @Modifying
     @Query(value = "update task_progress set status_id=2 where user_id=?1 and task_id=?2",nativeQuery = true)
     void updateStatus(int user_id,int task_id);
     @Query("select t from task_progress t where t.assigned_by=?1")
     List<TaskProgress> getTaskProgressByAssigned_by(int a);

}
