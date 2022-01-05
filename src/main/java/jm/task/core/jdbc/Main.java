package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        User user = new User("Виталий", "Грюков", (byte) 26);
        User user1 = new User("Илья", "Бабич", (byte) 27);
        User user2 = new User("Елена", "Бабич", (byte) 27);

        userService.saveUser(user.getName(), user.getLastName(), user.getAge());
        System.out.println("Пользователь с фамилией - " + user.getLastName() + " добавлен в базу данных");

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("Пользователь с фамилией - " + user1.getLastName() + " добавлен в базу данных");

        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("Пользователь с фамилией - " + user2.getLastName() + " добавлен в базу данных");


        userService.cleanUsersTable();

        for (int i = 0; i < userService.getAllUsers().size(); i++) {
            System.out.println(userService.getAllUsers().get(i));
        }

        userService.dropUsersTable();
    }
}
