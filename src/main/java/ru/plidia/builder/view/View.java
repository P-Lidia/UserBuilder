package ru.plidia.builder.view;

import ru.plidia.builder.model.entity.User;

import java.util.List;
import java.util.stream.Stream;

public class View {
    public void printSortList(Stream<User> userStream) {
        userStream.forEach(System.out::println);
    }

    public void printEvenIdList(List<User> userList) {
        userList.forEach(System.out::println);
    }
}
