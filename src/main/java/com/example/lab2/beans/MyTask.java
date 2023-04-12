package com.example.lab2.beans;

import com.example.lab2.dataClasses.Priority;
import com.example.lab2.dataClasses.Add_task_json;
import com.example.lab2.dataClasses.Update_task_json;


public class MyTask {
    private Priority priority;
    private String taskDateEnd;
    private String taskType;

    public MyTask(Add_task_json json) {
        this.priority = json.getPriority();
        this.taskDateEnd = json.getTaskDateEnd();
        this.taskType = json.getTaskType();
    }

    public MyTask(Update_task_json json) {
        this.priority = json.getNewPriority();
        this.taskDateEnd = json.getNewTaskDateEnd();
        this.taskType = json.getNewTaskType();
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getTaskDateEnd() {
        return taskDateEnd;
    }

    public void setTaskDateEnd(String taskDateEnd) {
        this.taskDateEnd = taskDateEnd;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "priority=" + priority +
                ", taskDateEnd='" + taskDateEnd + '\'' +
                ", taskType='" + taskType + '\'' +
                '}';
    }
}
