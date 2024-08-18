package com.example.SchedulerDemoApplication.Scheduler;

import com.example.SchedulerDemoApplication.entity.Task;
import com.example.SchedulerDemoApplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@EnableScheduling
public class TaskScheduler {
    @Autowired
    private TaskService taskService;

    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
    public void markOverdueTasks() {
        List<Task> tasks = taskService.findAll();
        for (Task task : tasks) {
            if (task.getDueDate().isBefore(LocalDate.now()) && !task.getStatus().equals("Completed")) {
                task.setStatus("Overdue");
                taskService.save(task);
            }
        }
    }
}
