package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {
    // тесты для класса Todos
    @Test
    public void addTodoToList() {
        Todos to = new Todos();
        String task = "Anarik";
        to.addTaskToList(task);
        Assertions.assertEquals(to.getAllTodos(), "Anarik ");
    }

    @Test
    public void addTodoToListAndSortThem() {
        Todos to = new Todos();
        String task1 = "Komarik";
        to.addTaskToList(task1);

        String task2 = "Fonarik";
        to.addTaskToList(task2);

        String task3 = "Binarik";
        to.addTaskToList(task3);

        String task4 = "Anarik";
        to.addTaskToList(task4);

        Assertions.assertEquals("Anarik Binarik Fonarik Komarik ", to.getAllTodos());
    }
    @Test
    public void removeTodoFromList() {
        Todos to = new Todos();
        String task1 = "Anarik";
        String task2 = "Fonarik";

        // содержимое списка до удаления задачи
        to.addTaskToList(task1);
        to.addTaskToList(task2);
        Assertions.assertEquals(to.getAllTodos(), "Anarik Fonarik ");

        // содержимое списка после удаления задачи
        to.removeTaskFromList(task1);
        Assertions.assertFalse(to.getTodosList().contains(task1));
        Assertions.assertEquals(to.getAllTodos(), "Fonarik ");
    }
}