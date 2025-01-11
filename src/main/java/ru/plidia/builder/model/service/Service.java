package ru.plidia.builder.model.service;

import ru.plidia.builder.model.entity.User;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.random;

public class Service {
    static AtomicLong nextId = new AtomicLong();
    final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public List<User> generateData(Stream<User> userStream) {
        List<User> userList = userStream.map(user -> {
            return user = User.newUserBuilder()
                    .setId(nextId.incrementAndGet())  // ПОПРОБОВАТЬ ЗДЕСЬ НЬЮ АТОМИК
                    .setLogin(IntStream.range(0, chars.length())
                            .limit((int) (5 + Math.random() * 10))
                            .map(i -> new Random().nextInt(chars.length()))
                            .mapToObj(i -> String.valueOf(chars.charAt(i)))
                            .collect(Collectors.joining()))
                    .setPassword(new StringBuilder(IntStream.range(0, chars.length())
                            .limit((int) (7 + Math.random() * 15))
                            .map(i -> new Random().nextInt(chars.length()))
                            .mapToObj(i -> String.valueOf(chars.charAt(i)))
                            .collect(Collectors.joining())))
                    .setAge((int) (random() * 100))
                    .build();
        }).collect(Collectors.toList());
        return userList;
    }

    public List<User> sortList(Stream<User> userStream) {
        List<User> userList = userStream.sorted(Comparator.comparing(User::getLogin))
                .collect(Collectors.toList());
        return userList;
    }

    public List<User> getEvenId(Stream<User> userStream) {
        List<User> userList = userStream.filter(user -> user.getId() % 2 == 0)
                .collect(Collectors.toList());
        return userList;
    }
}
