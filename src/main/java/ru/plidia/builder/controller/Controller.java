package ru.plidia.builder.controller;

import ru.plidia.builder.exception.NullSameIdAndAgeException;
import ru.plidia.builder.model.entity.User;
import ru.plidia.builder.model.service.Service;
import ru.plidia.builder.view.View;

import java.util.List;
import java.util.stream.Stream;

public class Controller {
    private final Service service;
    private final View view;

    public Controller() {
        this.service = new Service();
        this.view = new View();
    }

    public List<User> executeGenerateData(Stream<User> userStream) {
        return service.generateData(userStream);
    }

    public List<User> executeSortList(Stream<User> userStream) {
        return service.sortList(userStream);
    }

    public void executePrintSortList(Stream<User> userStream) {
        view.printSortList(userStream);
    }

    public List<User> executeGetEvenId(Stream<User> userStream) {
        return service.getEvenId(userStream);
    }

    public void executePrintEvenIdList(List<User> userList) {
        view.printEvenIdList(userList);
    }

    public List executeCheckSameIdAndAge(Stream<User> userStream) {
        return service.checkSameIdAndAge(userStream);
    }

    public void executePrintSameIdAndAgeList(Stream<User> userStream) {
        view.printSameIdAndAgeList(userStream);
    }
}