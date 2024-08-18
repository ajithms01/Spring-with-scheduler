package com.example.SchedulerDemoApplication.service;

import com.example.SchedulerDemoApplication.entity.Task;
import com.example.SchedulerDemoApplication.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void updateTaskStatus(Long id, String status) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(status);
        taskRepository.save(task);
    }
}
