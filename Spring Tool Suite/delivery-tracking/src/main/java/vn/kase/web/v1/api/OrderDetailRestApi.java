package vn.kase.web.v1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.OrderDetailDto;
import vn.kase.dto.v1.model.PackageDto;
import vn.kase.service.v1.OrderDetailService;
import vn.kase.service.v1.PackageService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-detail")
public class OrderDetailRestApi {
    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailRestApi(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping
    public Object addOrderDetail(@RequestBody OrderDetailDto orderDetailDto) {
        try {
            this.orderDetailService.add(orderDetailDto);
            return new ResponseEntity<String>("Successfully added new order.", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured adding a new order. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public Object getOrderDetail() {
        try {
            List<OrderDetailDto> orderDetailDtos = this.orderDetailService.findAll();
            return new ResponseEntity<Object>(orderDetailDtos, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("No orders exist.", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public Object getOrderDetail(@PathVariable("id") Long id) {
        try {
            OrderDetailDto orderDetailDto = this.orderDetailService.findById(id);
            return new ResponseEntity<Object>(orderDetailDto, HttpStatus.FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<String>("Order not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Object updateOrderDetail(@RequestBody OrderDetailDto orderDetailDto) {
        try {
            this.orderDetailService.update(orderDetailDto);
            return new ResponseEntity<String>("Successfully updated order detail.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured updating order detail. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object removeOrderDetail(@PathVariable("id") Long id) {
        try {
            this.orderDetailService.delete(id);
            return new ResponseEntity<String>("Order removed.", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<String>(String.format("Unknown error(s) occured removing order. \nError details: %s", exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}