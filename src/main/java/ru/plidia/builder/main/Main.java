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
        controller.executePrintSortList(controller.executeSortList(userList.stream()).stream());
        userList = controller.executeGetEvenId(userList.stream());
        controller.executePrintEvenIdList(userList);
        try {
            userList.get(0).checkBoolean(controller.executeCheckSameIdAndAge(userList.stream()));
            controller.executePrintSameIdAndAgeList(userList.stream().filter(u -> u.getId() == u.getAge()));
        } catch (NullSameIdAndAgeException e){
            System.out.println(e.getMessage());;
        }
    }
}
