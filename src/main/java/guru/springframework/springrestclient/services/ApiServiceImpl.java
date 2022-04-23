package guru.springframework.springrestclient.services;

import guru.springframework.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;
    private final String url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public List<User> getAllUsers() {

        ResponseEntity<List<User>> response =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

        return response.getBody();
    }
}
