package ua.senadnepr.textstat.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String loadTextFiles(RedirectAttributes attributes, Model model){

        model.addAttribute(attributes);

        return "load";
    }
}
