package main.controllers;

import main.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @RequestMapping("/home/{color}")
    public String homeWithColor(@PathVariable String color,
                       Model page) {
        page.addAttribute("username", "Eve");
        page.addAttribute("color", color);
        return "home.html";
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        if(logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();

        if (username == null || username.isEmpty() || username.equals("null")) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        return "main.html";
    }
}
