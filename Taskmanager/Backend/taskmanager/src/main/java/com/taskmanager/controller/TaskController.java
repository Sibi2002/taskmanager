package com.taskmanager.controller;
import com.taskmanager.model.Task;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true", methods = {RequestMethod.POST,RequestMethod.GET})
public class TaskController {
    private TaskService taskService;
@Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("api/admin/createtask")
    public int createTask(@RequestBody Task task){
        System.out.println(task.getTask_name());
       return taskService.createTask(task);
    }
    @GetMapping("api/admin/getalltask")
    public List<Task> getAllTasks(){
    return taskService.getAllTasks();
    }
}
