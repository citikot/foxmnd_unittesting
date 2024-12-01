package online.agatstudio;

import online.agatstudio.service.UserService;

public class Main {

    static UserService userService = new UserService();

    public static void main(String[] args) {
        userService.printUsers();
    }
}
