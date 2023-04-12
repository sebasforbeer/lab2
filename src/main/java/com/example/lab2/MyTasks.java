package com.example.lab2;

import com.example.lab2.beans.MyTask;
import com.example.lab2.dataClasses.FilterData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.*;


public class MyTasks {
    private final Map<String, MyTask> tasks = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(MyTasks.class);

    public String setTasks(MyTask task) {
        if (isExisting(task.getTaskType())) {return "that task exist";}
        tasks.put(task.getTaskType(), task);
        return "Ok";

    }

    public MyTask getTask(String task) {
        return tasks.get(task);
    }

    public String updateTask(MyTask task, String oldTaskType) {
        //System.out.println(task.getTaskType());
        //System.out.println(getTask(oldTaskType).toString());
        if (isExisting(task.getTaskType())) {return "that task no exist";}
        tasks.replace(oldTaskType, task);
        return "ok";
    }

    public String deleteTask(String taskType) {
        MyTask q = getTask(taskType);

        tasks.remove(taskType, getTask(taskType));
        return "ok";
    }


    public MyTask[] getAllTask() {
        MyTask[] arr = new MyTask[tasks.size()];
        int i = 0;
        for (MyTask task : tasks.values()) {
            arr[i] = task;
            i++;
        }
        return arr;
    }

    public List<FilterData> filter(String _date) {
        if (tasks.isEmpty()) {return null;}
        LocalDate neededDate = LocalDate.parse(_date);
        List<FilterData> allDate = new ArrayList<>();
        for (MyTask task : tasks.values()) {
            String strDate = task.getTaskDateEnd();
            allDate.add(
                    new FilterData(LocalDate.parse(strDate),
                    task.getPriority()));
        }
        List<FilterData> dateBefore = new ArrayList<>();

        for (FilterData date : allDate) {
            if (neededDate.isBefore(date.getDate())) {
                dateBefore.add(date);
            }
        }

        dateBefore.sort(Comparator.comparing(FilterData::getPriority));


        return dateBefore;
    }

    public String clean() {
        for (MyTask task : tasks.values()) {
            log.info("Task " + task.toString());
        }
        tasks.clear();
        return "ok";
    }

    private boolean isExisting(String taskType) {
        MyTask task = getTask(taskType);

        if (task == null) {return false;} else {return true;}
    }


}
