package com.example.SchedulerDemoApplication.controller;

import com.example.SchedulerDemoApplication.entity.Task;
import com.example.SchedulerDemoApplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}/status")
    public void updateTaskStatus(@PathVariable Long id, @RequestParam String status) {
        taskService.updateTaskStatus(id, status);
    }
}

