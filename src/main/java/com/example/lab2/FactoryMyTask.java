package com.example.lab2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryMyTask {


    @Bean
    public MyTasks myTasks() {
        return new MyTasks();
    }

    @Bean
    public MyTaskService taskService() {
        return new MyTaskService(myTasks());
    }

    @Bean
    public MyTaskController taskController() {
        return new MyTaskController(taskService(), clean());
    }

    @Bean("request")
    public CleanService clean() {
        return new CleanService(myTasks());
    }

    @Bean
    public ScheduledTasks scheduledTasks() {
        return new ScheduledTasks(myTasks());
    }

}
