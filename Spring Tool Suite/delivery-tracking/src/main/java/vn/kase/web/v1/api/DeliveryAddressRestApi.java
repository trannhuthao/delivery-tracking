package vn.kase.web.v1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.DeliveryAddressDto;
import vn.kase.service.v1.DeliveryAddressService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery-addresses")
public class DeliveryAddressRestApi {
    private final DeliveryAddressService deliveryAddressService;

    @Autowired
    public DeliveryAddressRestApi(DeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }

    @PostMapping
    public Object addDeliveryAddress(@RequestBody DeliveryAddressDto deliveryAddressDto) {
        try {
            this.deliveryAddressService.add(deliveryAddressDto);
            return new ResponseEntity<String>("Successfully added new delivery address.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new delivery address. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Object getDeliveryAddresses() {
        try {
            List<DeliveryAddressDto> deliveryAddressDto = this.deliveryAddressService.findAll();
            return new ResponseEntity<Object>(deliveryAddressDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No delivery addresses exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public Object getDeliveryAddress(@PathVariable("id") Long id) {
        try {
            DeliveryAddressDto deliveryAddressDto = this.deliveryAddressService.findById(id);
            return new ResponseEntity<Object>(deliveryAddressDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Delivery address not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Object updateDeliverAddress(@RequestBody DeliveryAddressDto deliveryAddressDto) {
        try {
            this.deliveryAddressService.update(deliveryAddressDto);
            return new ResponseEntity<String>("Successfully updated delivery address.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating delivery address. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object removeDeliveryAddress(@PathVariable("id") Long id) {
        try {
            this.deliveryAddressService.delete(id);
            return new ResponseEntity<String>("Delivery address removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing delivery address. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}