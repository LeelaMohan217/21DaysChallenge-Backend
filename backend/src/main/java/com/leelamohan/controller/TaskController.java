package com.leelamohan.controller;

import com.leelamohan.model.Task;
import com.leelamohan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task created successfully";
    }

    @GetMapping("/getAll")
    public List<Task> getAllTasksByUserId(@RequestParam String userId) {
        return taskService.getAllTasksByUserId(userId);
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam String task_id,@RequestParam int days,@RequestParam boolean isReset) {
        taskService.updateTask(task_id, days, isReset);
        return "Task updated successfully";
    }

    @PostMapping("/updatechallenge")
    public String updateChallenge(@RequestParam String task_id,@RequestParam String challenge,@RequestParam String description) {
        return taskService.updatechallenge(task_id, challenge, description);
    }


    @DeleteMapping("/delete/{task_id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long task_id) {
        boolean deleted = taskService.deleteTask(task_id);
        if (deleted) {
            return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
        }
    }
}
