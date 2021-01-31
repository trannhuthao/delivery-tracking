package vn.kase.web.v1.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.user.AddressDto;
import vn.kase.dto.v1.model.user.UserDto;
import vn.kase.service.v1.user.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressRestApi {
    private final AddressService addressService;

    @Autowired
    public AddressRestApi(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public Object addAddress(@RequestBody AddressDto addressDto) {
        try {
            this.addressService.add(addressDto);
            return new ResponseEntity<String>("Successfully added new address.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new address. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Object getAddresses() {
        try {
            List<AddressDto> addressDtos = this.addressService.findAll();
            return new ResponseEntity<Object>(addressDtos, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No addresses exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public Object getAddress(@PathVariable("id") Long id) {
        try {
            AddressDto addressDto = this.addressService.findById(id);
            return new ResponseEntity<Object>(addressDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Address not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Object updateAddress(@RequestBody AddressDto addressDto) {
        try {
            this.addressService.update(addressDto);
            return new ResponseEntity<String>("Successfully updated address.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating address. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object removeAddress(@PathVariable("id") Long id) {
        try {
            this.addressService.delete(id);
            return new ResponseEntity<String>("Address removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing address. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}