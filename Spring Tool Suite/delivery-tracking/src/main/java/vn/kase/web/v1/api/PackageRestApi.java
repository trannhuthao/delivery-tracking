package vn.kase.web.v1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.PackageDto;
import vn.kase.service.v1.PackageService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packages")
public class PackageRestApi {
    private final PackageService packageService;

    @Autowired
    public PackageRestApi(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping(path = { "" })
    public Object addShippingPackage(@RequestBody PackageDto packageDto) {
        try {
            this.packageService.add(packageDto);
            return new ResponseEntity<String>("Successfully added new shipping package.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new shipping package. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = { "" })
    public Object getShippingPackages() {
        try {
            List<PackageDto> packageDtos = this.packageService.findAll();
            return new ResponseEntity<Object>(packageDtos, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No shipping packages exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = { "/{id}" })
    public Object getShippingPackage(@PathVariable("id") Long id) {
        try {
            PackageDto packageDto = this.packageService.findById(id);
            return new ResponseEntity<Object>(packageDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Shipping package not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = { "" })
    public Object updateShippingPackage(@RequestBody PackageDto packageDto) {
        try {
            this.packageService.update(packageDto);
            return new ResponseEntity<String>("Successfully updated shipping package.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating shipping package. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = { "/{id}" })
    public Object removeShippingPackage(@PathVariable("id") Long id) {
        try {
            this.packageService.delete(id);
            return new ResponseEntity<String>("Shipping package removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing shipping package. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}