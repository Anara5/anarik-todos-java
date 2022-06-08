package ru.netology.javacore;

import java.util.*;

public class Todos {

    // Выбрала более простой способ для перечисления задача в форме строк - ArrayList
    private List<String> todosList = new ArrayList<>();

    public List<String> getTodosList() {
        return todosList;
    }

    public void setTodosList(List<String> todosList) {
        this.todosList = todosList;
    }

    public void addTaskToList(String task) {
        todosList.add(task);
    }

    public void removeTaskFromList(String task) {
        todosList.remove(task);
    }

    // распечатать список всех задач в строке
    public String getAllTodos() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(todosList);
        for (String todos: todosList)
            sb
                    .append(todos)
                    .append(" ");
        return sb.toString();
    }
}