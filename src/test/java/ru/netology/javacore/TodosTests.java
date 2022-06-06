package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {
    // тесты для класса Todos
    @Test
    public void addTodoToList() {
        Todos todos = new Todos();
        todos.addTask("Аnarik");
        String task = todos.toString();
        todos.addTaskToList();

        Assertions.assertEquals(todos.getTask(), task);
    }
    @Test
    public void addTodoToListAndSortThem() {
        Todos todos1 = new Todos();
        todos1.addTask("Komarik");
        todos1.addTaskToList();

        Todos todos2 = new Todos();
        todos2.addTask("Fonarik");
        todos2.addTaskToList();

        Todos todos3 = new Todos();
        todos3.addTask("Binarik");
        todos3.addTaskToList();

        Todos todos4 = new Todos();
        todos4.addTask("Anarik");
        todos4.addTaskToList();

        Assertions.assertEquals("Anarik Binarik Fonarik Komarik ", Todos.getAllTasks());
    }
    @Test
    public void removeTodoFromList() {
        Todos todos = new Todos();
        todos.addTask("Аnarik");
        String task = todos.toString();
        todos.addTaskToList();

        // list contains before removing
        Assertions.assertEquals(todos.getTask(), task);

        // list contains after removing
        Todos.removeTask(task);
        Assertions.assertFalse(Todos.getTodosList().contains(task));
    }
}