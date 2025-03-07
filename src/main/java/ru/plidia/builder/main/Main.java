package ru.plidia.builder.main;

import ru.plidia.builder.controller.Controller;
import ru.plidia.builder.exception.NullSameIdAndAgeException;
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
        userList = controller.executeGetEvenId(userList.stream());
        controller.executePrintEvenIdList(userList);
        try {
            if (userList.get(0).checkBoolean(userList)) {
                userList = controller.executeCheckSameIdAndAge(userList.stream());
                controller.executePrintSameIdAndAgeList(userList.stream());
            }
        } catch (NullSameIdAndAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
