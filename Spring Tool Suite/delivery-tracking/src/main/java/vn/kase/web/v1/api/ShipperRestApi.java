package vn.kase.web.v1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.PackageDto;
import vn.kase.dto.v1.model.ShipperDto;
import vn.kase.service.v1.PackageService;
import vn.kase.service.v1.ShipperService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippers")
public class ShipperRestApi {
    private final ShipperService shipperService;

    @Autowired
    public ShipperRestApi(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @PostMapping
    public Object addShipper(@RequestBody ShipperDto shipperDto) {
        try {
            this.shipperService.add(shipperDto);
            return new ResponseEntity<String>("Successfully added new shipper.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new shipper. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Object getShipper() {
        try {
            List<ShipperDto> shipperDtos = this.shipperService.findAll();
            return new ResponseEntity<Object>(shipperDtos, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No shippers exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public Object getShipper(@PathVariable("id") Long id) {
        try {
            ShipperDto shipperDto = this.shipperService.findById(id);
            return new ResponseEntity<Object>(shipperDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Shipper not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Object updateShipper(@RequestBody ShipperDto shipperDto) {
        try {
            this.shipperService.update(shipperDto);
            return new ResponseEntity<String>("Successfully updated shipper.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating shipper. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object removeShipper(@PathVariable("id") Long id) {
        try {
            this.shipperService.delete(id);
            return new ResponseEntity<String>("Shipper removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing shipper. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}