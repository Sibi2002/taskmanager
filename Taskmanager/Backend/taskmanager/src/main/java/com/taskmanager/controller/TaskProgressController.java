package com.taskmanager.controller;

import com.taskmanager.dto.AssignedTaskDto;
import com.taskmanager.dto.TaskAssignDto;
import com.taskmanager.model.TaskProgress;
import com.taskmanager.service.TaskProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class TaskProgressController {
    private TaskProgressService taskProgressService;
   @Autowired
    public TaskProgressController(TaskProgressService taskProgressService) {
        this.taskProgressService = taskProgressService;
    }

    @GetMapping("api/{user_name}/assigned")
    public List<AssignedTaskDto> getAssignedTasks(@PathVariable String user_name){
        return taskProgressService.getAssignedTasks(user_name);
    }@GetMapping("api/{user_name}/completed")
    public List<AssignedTaskDto> getCompletedTasks(@PathVariable String user_name){
        return taskProgressService.getCompletedTasks(user_name);
    }
    @GetMapping("api/{user_name}/overdue")
    public List<AssignedTaskDto> getOverDueTasks(@PathVariable String user_name){
        return taskProgressService.getOverDueTasks(user_name);
    }
    @GetMapping("api/alltask")
    public List<TaskProgress >getTaskByAdmin(){
        return taskProgressService.getTasksByAdmin();
    }
    @PostMapping("api/admin/assigntask")
    public void assignTask(@RequestBody TaskAssignDto taskAssignDto){
        taskProgressService.assignTask(taskAssignDto);
    }
    @PostMapping("api/{user_name}/{task_id}/status_update")
    public void updateStatus(@PathVariable String user_name,@PathVariable int task_id ){
        taskProgressService.updateStatus(user_name,task_id);
    }
}
