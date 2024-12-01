package online.agatstudio.service;

import online.agatstudio.repository.UserRepository;

import java.util.List;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public void printUsers() {
        for (String user : userRepository.getUsers()) {
            System.out.println(user);
        }

    }
}
