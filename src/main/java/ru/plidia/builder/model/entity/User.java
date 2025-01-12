package ru.plidia.builder.model.entity;

import ru.plidia.builder.exception.NullSameIdAndAgeException;

public class User implements Comparable<User> {
    Long id;
    String login;
    StringBuilder password;
    Integer age;

    private User() {
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public static UserBuilder newUserBuilder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder {

        private UserBuilder() {
        }

        public UserBuilder setId(Long id) {
            User.this.id = id;
            return this;
        }

        public UserBuilder setLogin(String login) {
            User.this.login = login;
            return this;
        }

        public UserBuilder setPassword(StringBuilder password) {
            User.this.password = password;
            return this;
        }

        public UserBuilder setAge(int age) {
            User.this.age = age;
            return this;
        }

        public User build() {
            return User.this;
        }
    }

    @Override
    public int compareTo(User o) {
        return o.login.compareTo(this.login);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("\nid=").append(id).append(", login=").append(login)
                .append(", password=").append(password).append(", age=").append(age).toString();
    }

    public void check(boolean any) throws NullSameIdAndAgeException {
        if (any == false) {
            throw new NullSameIdAndAgeException("Нет совпадений");
        }
    }
}