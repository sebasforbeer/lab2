package com.example.lab2;


public class CleanService {
    private final MyTasks tasks;

    public CleanService(MyTasks tasks) {
        this.tasks = tasks;
    }

    public String clean() {
        return tasks.clean();
    }


}
