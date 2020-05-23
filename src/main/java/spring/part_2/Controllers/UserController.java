package spring.part_2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserController() {
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("activePage", "Users");
        return "users";
    }
}
