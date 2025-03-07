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
    private static AtomicLong nextId = new AtomicLong();
    private final String chars;

    public Service() {
        this.chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    }

    public List<User> generateData(Stream<User> userStream) {
        return userStream.map(user -> {
            return user = User.newUserBuilder()
                    .setId(nextId.incrementAndGet())
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
    }

    public List<User> sortList(Stream<User> userStream) {
        return userStream.sorted(Comparator.comparing(User::getLogin)).collect(Collectors.toList());
    }

    public List<User> getEvenId(Stream<User> userStream) {
        return userStream.filter(user -> user.getId() % 2 == 0).collect(Collectors.toList());
    }

    public List<User> checkSameIdAndAge(Stream<User> userStream) {
        return userStream.filter(u -> u.getId() == u.getAge()).collect(Collectors.toList());
    }
}
