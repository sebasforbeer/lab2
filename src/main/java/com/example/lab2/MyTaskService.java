package com.example.lab2;

import com.example.lab2.beans.MyTask;
import com.example.lab2.dataClasses.Add_task_json;
import com.example.lab2.dataClasses.FilterData;
import com.example.lab2.dataClasses.Update_task_json;

import java.time.LocalDate;
import java.util.List;


public class MyTaskService {

    private final MyTasks myTasks;

    public MyTaskService(MyTasks myTasks) {
        this.myTasks = myTasks;
    }

    public String saveMyTask(Add_task_json json) {
        MyTask myTask = new MyTask(json);
        return myTasks.setTasks(myTask);
    }

    public String updateMyTask(Update_task_json json) {
        MyTask myTask = new MyTask(json);
        //System.out.println("aa "+ json.getTaskType());
        return myTasks.updateTask(myTask, json.getTaskType());

    }

    public String deleteMyTask(String task) {
        return myTasks.deleteTask(task);
    }

    public MyTask[] getTasks() {
        return myTasks.getAllTask();
    }

    public String getTask(String task) {
        MyTask myTask = myTasks.getTask(task);
        if (myTask == null) {
            return "Not found task by this type";
        }
        return myTask.toString();
    }

    public String clean() {
        return myTasks.clean();
    }
    public List<FilterData> filter(String date) {
        return myTasks.filter(date);
    }

}
