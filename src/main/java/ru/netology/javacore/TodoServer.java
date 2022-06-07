package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.GsonBuildConfig;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        String input;
        Gson gson = new Gson();
        // server connection
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Starting server at " + port + "...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                     input = in.readLine();

                    Manager manage = gson.fromJson(input, Manager.class);
                    String type = manage.type;
                    String task = manage.task;

                    if (type.equals("ADD")) {
                        new Todos().addTask(task);
                        out.println("Задача: " + task + " внесена в список.");
                    }
                    if (type.equals("REMOVE")) {
                        new Todos().removeTask(task);
                        out.println("Задача " + task + " удалена из списка.");
                    }
                    out.println("Полный список задач: " + todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
