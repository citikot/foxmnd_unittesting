package online.agatstudio.repository;

import java.util.List;

public class UserRepository {

    private final List<String> users = List.of("Ivan", "Maris", "Maria", "Stephan");

    public List<String> getUsers() {
        return users;
    }

}
