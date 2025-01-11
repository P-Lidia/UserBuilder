package ru.plidia.builder.view;

import ru.plidia.builder.model.entity.User;

import java.util.stream.Stream;

public class View {
    public void printSortList(Stream<User> userStream) {
        userStream.forEach(System.out::println);
    }
}
