package vn.kase.web.v1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.RoleDto;
import vn.kase.service.v1.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleRestApi {
    private final RoleService roleService;

    @Autowired
    public RoleRestApi(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Object addRole(@RequestBody RoleDto roleDto) {
        try {
            this.roleService.add(roleDto);
            return new ResponseEntity<String>("Successfully added new role.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new role. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Object getRoles() {
        try {
            List<RoleDto> roleDtos = this.roleService.findAll();
            return new ResponseEntity<Object>(roleDtos, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No roles exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public Object getRole(@PathVariable("id") Long id) {
        try {
            RoleDto roleDto = this.roleService.findById(id);
            return new ResponseEntity<Object>(roleDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Role not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Object updateRole(@RequestBody RoleDto roleDto) {
        try {
            this.roleService.update(roleDto);
            return new ResponseEntity<String>("Successfully updated role.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating role. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object removeRole(@PathVariable("id") Long id) {
        try {
            this.roleService.delete(id);
            return new ResponseEntity<String>("Shipping package removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing shipping package. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}