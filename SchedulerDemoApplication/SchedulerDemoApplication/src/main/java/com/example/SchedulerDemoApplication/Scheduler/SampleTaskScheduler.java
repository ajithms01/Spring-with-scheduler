package com.example.SchedulerDemoApplication.Scheduler;

import com.example.SchedulerDemoApplication.entity.Task;
import com.example.SchedulerDemoApplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@EnableScheduling
public class SampleTaskScheduler {
    @Autowired
    private TaskService taskService;

    // Example of a cron job
    @Scheduled(cron = "0 0 0 * * ?") // Runs every 30s
    public void markOverdueTasks() {
        List<Task> tasks = taskService.findAll();
        for (Task task : tasks) {
            if (task.getDueDate().isBefore(LocalDate.now()) && !task.getStatus().equalsIgnoreCase("Completed")) {
                task.setStatus("Overdue");
                taskService.save(task);
            }
        }
    }

    // Example of a fixed rate job
//    @Scheduled(fixedRate = 6000)
//    public void printCurrentTime() throws InterruptedException {
//        System.out.println("Current time: " + LocalTime.now());
//    }

    // Example of a fixed delay job
//    @Scheduled(fixedDelay = 5000)
//    public void printCurrentTime() throws InterruptedException {
//        System.out.println("Current time: " + LocalTime.now());
//        Thread.sleep(1000);
//    }

    // Example of a initial delay job
//    @Scheduled(fixedDelay = 3000,initialDelay = 5000)
//    public void printCurrentTime() throws InterruptedException {
//        System.out.println("Current time: " + LocalTime.now());
//    }

    // Example of a cron job
//    @Scheduled(cron = "0 47 22 * * ?")
//    public void printCurrentTime() throws InterruptedException {
//        System.out.println("Current time: " + LocalTime.now());
//    }
}
