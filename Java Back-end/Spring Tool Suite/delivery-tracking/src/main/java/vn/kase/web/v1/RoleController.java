package vn.kase.web.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.RoleDto;
import vn.kase.service.v1.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String getRoles(Model model) {
        model.addAttribute("roles", this.roleService.findAll());
        return "v1/role/index";
    }

    @GetMapping("/detail")
    public String getRoleById(final Model model, final @RequestParam("id") Long id) {
        model.addAttribute("roleDto", this.roleService.findById(id));
        return "v1/role/detail";
    }

    @GetMapping("/add")
    public String addRole(Model model) {
        model.addAttribute("roleDto", new RoleDto());
        return "v1/role/add";
    }

    @PostMapping("/add")
    public String addRole(
            Model model,
            @ModelAttribute("roleDto") RoleDto roleDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/role/add";
        }

        try {
            this.roleService.add(roleDto);
            return "redirect:/roles";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Add new role failed. Try again.");
        return "v1/role/add";
    }

    @GetMapping("/update")
    public String updateRole(@RequestParam("id") Long id, Model model) {
        model.addAttribute("roleDto", this.roleService.findById(id));
        return "v1/role/update";
    }

    @PostMapping("/update")
    public String updateRole(
            Model model,
            @ModelAttribute("roleDto") RoleDto roleDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/role/update";
        }

        try {
            this.roleService.update(roleDto);
            return "redirect:/roles";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating role failed. Try again.");
        return "v1/role/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        this.roleService.delete(id);
        return "redirect:/roles";
    }
}