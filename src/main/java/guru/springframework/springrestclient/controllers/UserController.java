package guru.springframework.springrestclient.controllers;

import guru.springframework.springrestclient.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"/", "/index", "/index.html"})
    public String showUsers(Model model) {
        model.addAttribute("users", apiService.getAllUsers());
        return "index";
    }
}
