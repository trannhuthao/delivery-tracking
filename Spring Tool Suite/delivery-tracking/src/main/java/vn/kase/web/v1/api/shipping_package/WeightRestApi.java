package vn.kase.web.v1.api.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.shipping_package.PackageDto;
import vn.kase.dto.v1.model.shipping_package.WeightDto;
import vn.kase.service.v1.shipping_package.WeightService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weights")
public class WeightRestApi {
    private final WeightService weightService;

    @Autowired
    public WeightRestApi(WeightService weightService) {
        this.weightService = weightService;
    }

    @PostMapping
    public Object addWeightRange(@RequestBody WeightDto weightDto) {
        try {
            this.weightService.add(weightDto);
            return new ResponseEntity<String>("Successfully added new weight range.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new weight range. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Object getWeightRange() {
        try {
            List<WeightDto> weightDtos = this.weightService.findAll();
            return new ResponseEntity<Object>(weightDtos, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No weight ranges exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public Object getWeightRange(@PathVariable("id") Long id) {
        try {
            WeightDto weightDto = this.weightService.findById(id);
            return new ResponseEntity<Object>(weightDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Weight range not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Object updateWeightRange(@RequestBody WeightDto weightDto) {
        try {
            this.weightService.update(weightDto);
            return new ResponseEntity<String>("Successfully updated weight range.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating weight range. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object removeWeightRange(@PathVariable("id") Long id) {
        try {
            this.weightService.delete(id);
            return new ResponseEntity<String>("Weight range removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing weight range. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}