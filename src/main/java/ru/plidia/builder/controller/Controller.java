package ru.plidia.builder.controller;

import ru.plidia.builder.model.entity.User;
import ru.plidia.builder.model.service.Service;
import ru.plidia.builder.view.View;

import java.util.List;
import java.util.stream.Stream;

public class Controller {
    Service service = new Service();
    View view = new View();

    public List<User> executeGenerateData(Stream<User> userStream) {
        return service.generateData(userStream);
    }
}
