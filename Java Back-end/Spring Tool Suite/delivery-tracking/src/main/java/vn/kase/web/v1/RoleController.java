package vn.kase.web.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String getRoles(final Model model) {
//        model.addAttribute("roles", this.roleService.findAll());
//        return "v1/role/index";
    	
    	return this.getRolesPaginated(1, "roleName", "asc", model);
    }
    
    @GetMapping("/{page}")
    public String getRolesPaginated(
            final @PathVariable(value = "page") int page,
            final @RequestParam("sortField") String sortField,
            final @RequestParam("sortDirection") String sortDirection,
            final Model model
    ) {
    	int size = 5;
    	Page<RoleDto> rolesPaginated = this.roleService.findAllPaginated(page, size, sortField, sortDirection);
    	List<RoleDto> roles = rolesPaginated.getContent();
    	
    	model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", rolesPaginated.getTotalPages());
        model.addAttribute("totalElements", rolesPaginated.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("roles", roles);

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