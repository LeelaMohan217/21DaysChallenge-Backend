package com.leelamohan.service;

import com.leelamohan.model.Task;
import com.leelamohan.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasksByUserId(String userId) {
        return taskRepository.findByUserId(userId);
    }

    @Transactional
    public void updateTask(String taskid, int days , boolean isReset) {
        if(isReset){
            taskRepository.resetCompletedDays(Long.valueOf(taskid));
        }
        else if(days>0) {
            taskRepository.incrementCompletedDays(Long.valueOf(taskid));
        }
        else {
            taskRepository.decrementCompletedDays(Long.valueOf(taskid));
        }
    }

    @Transactional
    public String updatechallenge(String id,String challenge, String description){
        Long task_id = Long.parseLong(id);
        Optional<Task> taskOptional = taskRepository.findById(task_id);

        if(taskOptional.isPresent()){
            taskRepository.updateChallenge(task_id, challenge, description);
            return "task updated successfully";
        }
        else{
            return "task not found";
        }
    }

    public boolean deleteTask(Long task_id) {
        Optional<Task> taskOptional = taskRepository.findById(task_id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            taskRepository.delete(task);
            return true; // Task found and deleted successfully
        } else {
            return false; // Task not found
        }
    }
}

