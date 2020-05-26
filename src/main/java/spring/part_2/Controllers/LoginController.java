package spring.part_2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.part_2.repository.RoleRepository;
import spring.part_2.service.UserRepr;
import spring.part_2.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public LoginController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public String login() {
        return "myLogin";
    }

    @GetMapping("/registration")
    public String reg(Model model) {
        model.addAttribute("user", new UserRepr());
        model.addAttribute("roles", roleRepository.findById(1L));
        return "registration";
    }

    @PostMapping("/registration")
    public String newUser(@Valid UserRepr user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            result.rejectValue("password", "", "Password not matching");
            return "registration";
        }

        userService.registration(user);
        return "redirect:/login";
    }
}
