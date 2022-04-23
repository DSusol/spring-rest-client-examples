package guru.springframework.springrestclient.services;

import guru.springframework.api.domain.User;

import java.util.List;

public interface ApiService {
    List<User> getAllUsers();
}
