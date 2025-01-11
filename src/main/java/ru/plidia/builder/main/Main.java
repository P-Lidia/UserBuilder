package ru.plidia.builder.main;

import ru.plidia.builder.controller.Controller;
import ru.plidia.builder.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            userList.add(null);
        }
        userList = controller.executeGenerateData(userList.stream());
        userList = controller.executeSortList(userList.stream());
        controller.executePrintSortList(userList.stream());
    }
}
