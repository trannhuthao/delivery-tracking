package vn.kase.web.v1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.user.UserDto;
import vn.kase.service.v1.RoleService;
import vn.kase.service.v1.shipping_package.PackageService;
import vn.kase.service.v1.user.AddressService;
import vn.kase.service.v1.user.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private RoleService roleService;
    private AddressService addressService;
    private PackageService packageService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    public void setPackageService(PackageService packageService) {
        this.packageService = packageService;
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
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("shippingPackages", this.packageService.findAll());
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
        model.addAttribute("errorMessage", "Updating user failed. Try again.");
        return "v1/user/add";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("userDto", this.userService.findById(id));
        model.addAttribute("roles", this.roleService.findAll());
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("shippingPackages", this.packageService.findAll());
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