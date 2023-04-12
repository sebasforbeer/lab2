package com.example.lab2;

import com.example.lab2.beans.MyTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTasks {
    private final MyTasks myTasks;
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);


    public ScheduledTasks(MyTasks myTasks) {
        this.myTasks = myTasks;
    }


    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        MyTask[] arr = myTasks.getAllTask();
        for (MyTask task : arr) {
            log.info(task.getTaskType());
            log.info(task.getTaskDateEnd());
            log.info(task.getPriority().name());
        }
    }
}
