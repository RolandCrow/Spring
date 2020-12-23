package SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
