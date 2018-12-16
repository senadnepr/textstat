package ua.senadnepr.textstat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/home")
    public String rootHome() {
        return "index";
    }

    @GetMapping("/view")
    public String setUser() {

        return "view";
    }

    @GetMapping("/load")
    public String loadTextFiles(){

        return "load";
    }
}
