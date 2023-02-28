package com.taskmanager.service;

import com.taskmanager.dto.AssignedTaskDto;
import com.taskmanager.dto.TaskAssignDto;
import com.taskmanager.model.TaskProgress;
import com.taskmanager.model.User;
import com.taskmanager.repository.TaskProgressRepository;
import com.taskmanager.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskProgressService {

    @Autowired
    private TaskProgressRepository taskProgressRepository;
    @Autowired
    private UserRepository userRepository;
    public void assignTask(TaskAssignDto taskAssignDto){
        Date date = new Date();
       int user_id= userRepository.getUserByName(taskAssignDto.getUser_name()).getUser_id();
       int assigned_by=userRepository.getUserByName(taskAssignDto.getAssigned_by()).getUser_id();
        TaskProgress taskProgress=new TaskProgress(taskAssignDto.getDue_date(),user_id,taskAssignDto.getTask_id(), assigned_by);
        taskProgress.setAssigned_date(date);
        taskProgress.setStatus_id(1);
             taskProgressRepository.save(taskProgress);
        }
    public List<AssignedTaskDto> getAssignedTasks(String user_name){
        int user_id= userRepository.getUserByName(user_name).getUser_id();
        return taskProgressRepository.getAssignedTask(user_id);
    }
    @Transactional
    public void updateStatus( String user_name,int task_id){
       int user_id= userRepository.getUserByName(user_name).getUser_id();
         taskProgressRepository.updateStatus(user_id,task_id);
    }
    public List<AssignedTaskDto> getCompletedTasks(String user_name){
        int user_id= userRepository.getUserByName(user_name).getUser_id();
        return taskProgressRepository.getCompletedTask(user_id);
    }
    public List<AssignedTaskDto> getOverDueTasks(String user_name){
        int user_id= userRepository.getUserByName(user_name).getUser_id();
        return taskProgressRepository.getOverDueTask(user_id);
    }
    public List<TaskProgress> getTasksByAdmin(){
        return taskProgressRepository.findAll();

      }
}
