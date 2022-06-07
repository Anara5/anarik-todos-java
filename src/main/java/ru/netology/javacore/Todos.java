package ru.netology.javacore;

import java.util.*;

public class Todos {
    // a tree set of todos
    public static TreeSet<Todos> todosList = new TreeSet<>(Comparator.comparing(Todos::getTask));
    private String task;
    public Todos(String task) {
        this.task = task;
    }
    public Todos(){
    }
    public void addTask(String task) {
        this.task = task;
    }
    public String getTask() {
        return task;
    }
    public TreeSet<Todos> getTodosList() {
        return todosList;
    }
    public void addTaskToList() {
        todosList.add(this);
    }
    public void removeTask(String task) {
        // remove task from list
        todosList.removeIf(todos -> todos.getTask().equals(task));
    }
    public static String getAllTasks() {
        // print all tasks list
        StringBuilder sb = new StringBuilder();
        for (Todos todos: Todos.todosList)
            sb
                    .append(todos.toString())
                    .append(" ");
        return sb.toString();
    }
    @Override
    public String toString() {
        return task;
    }
}