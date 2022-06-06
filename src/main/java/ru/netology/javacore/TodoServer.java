package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private final int port;

    public TodoServer(int port, Todos todos) {
        this.port = port;
    }

    public void start() {
        new Gson();
        String input;
        // server connection
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Starting server at " + port + "...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    input = in.readLine();
                    JsonElement node = JsonParser.parseString(input);
                    JsonObject jsonObject = node.getAsJsonObject();

                    String type = jsonObject.get("type").getAsString();
                    String task = jsonObject.get("task").getAsString();

                    if (type.equals("ADD")) {
                        new Todos(task).addTaskToList();
                    } else {
                        Todos.removeTask(task);
                    }

                    out.println(Todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
