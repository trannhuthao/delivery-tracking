package vn.kase.web.v1.api.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.shipping_package.BoxSizeDto;
import vn.kase.dto.v1.model.shipping_package.WeightDto;
import vn.kase.service.v1.shipping_package.BoxSizeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/box-sizes")
public class BoxSizeRestApi {
    private final BoxSizeService boxSizeService;

    @Autowired
    public BoxSizeRestApi(BoxSizeService boxSizeService) {
        this.boxSizeService = boxSizeService;
    }

    @PostMapping
    public Object addBoxSize(@RequestBody BoxSizeDto boxSizeDto) {
        try {
            this.boxSizeService.add(boxSizeDto);
            return new ResponseEntity<String>("Successfully added new box size.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new box size. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Object getBoxSize() {
        try {
            List<BoxSizeDto> boxSizeDtos = this.boxSizeService.findAll();
            return new ResponseEntity<Object>(boxSizeDtos, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No box sizes exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public Object getBoxSize(@PathVariable("id") Long id) {
        try {
            BoxSizeDto boxSizeDto = this.boxSizeService.findById(id);
            return new ResponseEntity<Object>(boxSizeDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Box size not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Object updateBoxSize(@RequestBody BoxSizeDto boxSizeDto) {
        try {
            this.boxSizeService.update(boxSizeDto);
            return new ResponseEntity<String>("Successfully updated box size.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating box size. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object removeBoxSize(@PathVariable("id") Long id) {
        try {
            this.boxSizeService.delete(id);
            return new ResponseEntity<String>("Box size removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing box size. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}