package vn.kase.web.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.UserDto;
import vn.kase.service.v1.RoleService;
import vn.kase.service.v1.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", this.userService.findAll());
        return "v1/user/index";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roles", this.roleService.findAll());
        return "v1/user/add";
    }

    @PostMapping("/add")
    public String addUser(
            Model model,
            @ModelAttribute("userDto") UserDto userDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/user/add";
        }

        try {
            this.userService.add(userDto);
            return "redirect:/users";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "v1/user/add";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("userDto", this.userService.findById(id));
        model.addAttribute("roles", this.roleService.findAll());
        return "v1/user/update";
    }

    @PostMapping("/update")
    public String updateUser(
            Model model,
            @ModelAttribute("userDto") UserDto userDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/user/update";
        }

        try {
            this.userService.update(userDto);
            return "redirect:/users";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating user failed. Try again.");
        return "v1/user/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        this.userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/login")
    public String login() {
        return "v1/user/login";
    }

    @GetMapping("/register")
    public String register() {
        return "v1/user/register";
    }
}