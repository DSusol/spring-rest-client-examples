package guru.springframework.springrestclient.services;

import guru.springframework.api.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getAllUsers() {

        ResponseEntity<List<User>> response =
                restTemplate.exchange("https://jsonplaceholder.typicode.com/users",
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

        return response.getBody();
    }
}
