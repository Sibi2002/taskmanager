package com.taskmanager.service;

import com.taskmanager.model.SessionManagement;
import com.taskmanager.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    public void save(SessionManagement sessionManagement){
        sessionRepository.save(sessionManagement);
    }
    public SessionManagement getAuth(UUID id){
       return  sessionRepository.getReferenceById(id);
    }
    public void deleteById(UUID id){
         sessionRepository.deleteById(id);
    }
}
