package ru.plidia.builder.view;

import ru.plidia.builder.model.entity.User;

import java.util.List;
import java.util.stream.Stream;

public class View {
    public void printSortList(Stream<User> userStream) {
        System.out.println("\nAll users: ");
        userStream.forEach(System.out::println);
    }

    public void printEvenIdList(List<User> userList) {
        System.out.println("\nEven-id users: ");
        userList.forEach(System.out::println);
    }

    public void printSameIdAndAgeList(Stream<User> userStream) {
        System.out.println("\nUsers with the same id and age: ");
        userStream.forEach(System.out::println);
    }
}
