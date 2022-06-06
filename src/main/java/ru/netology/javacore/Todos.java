package ru.netology.javacore;

import java.util.*;
public class Todos {
    // a tree set of todos
    static TreeSet<Todos> todosList = new TreeSet<>(Comparator.comparing(Todos::getTask));
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
    public static TreeSet<Todos> getTodosList() {
        return todosList;
    }
    public void addTaskToList() {
        todosList.add(this);
    }
    public static void removeTask(String task) {
        // remove task from list
        Iterator<Todos> iterate = todosList.iterator();
        while(iterate.hasNext()) {
            Todos todos = iterate.next();
            if (todos.getTask().equals(task)){
                todosList.remove(todos);
            }
        }
    }
    public static String getAllTasks() {
        // print all tasks list
        StringBuilder sb = new StringBuilder();
        for (Todos todos: todosList) {
            sb
                    .append(todos.toString())
                    .append(" ");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return task;
    }
}