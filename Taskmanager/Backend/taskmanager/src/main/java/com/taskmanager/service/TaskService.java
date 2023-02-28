package com.taskmanager.service;
import com.taskmanager.model.Task;
import com.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    @Autowired
    private TaskRepository taskDao;
   public int createTask( Task task){
       if(taskDao.getTaskByName(task.getTask_name())!=null){
           return 0;
       }
       taskDao.save(task);
       return 1;
   }
   public List<Task> getAllTasks(){
       return taskDao.findAll();
   }
}
