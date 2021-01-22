package vn.kase.web.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.DeliveryAddressDto;
import vn.kase.service.v1.DeliveryAddressService;

@Controller
@RequestMapping("/delivery-addresses")
public class DeliveryAddressController {
    private final DeliveryAddressService deliveryAddressService;

    @Autowired
    public DeliveryAddressController(DeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }

    @GetMapping
    public String getDeliveryAddresses(Model model) {
        model.addAttribute("deliveryAddresses", this.deliveryAddressService.findAll());
        return "v1/delivery-address/index";
    }

    @GetMapping("/add")
    public String addDeliveryAddress(Model model) {
        model.addAttribute("deliveryAddressesDto", new DeliveryAddressDto());
        return "v1/delivery-address/add";
    }

    @PostMapping("/add")
    public String addDeliveryAddress(
            Model model,
            @ModelAttribute("deliveryAddressesDto") DeliveryAddressDto deliveryAddressDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/delivery-address/add";
        }

        try {
            this.deliveryAddressService.add(deliveryAddressDto);
            return "redirect:/delivery-addresses";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "v1/delivery-address/add";
    }

    @GetMapping("/update")
    public String updateDeliveryAddress(@RequestParam("id") Long id, Model model) {
        model.addAttribute("deliveryAddressDto", this.deliveryAddressService.findById(id));
        return "v1/delivery-address/update";
    }

    @PostMapping("/update")
    public String updateDeliveryAddress(
            Model model,
            @ModelAttribute("deliveryAddressDto") DeliveryAddressDto deliveryAddressDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/delivery-address/update";
        }

        try {
            this.deliveryAddressService.update(deliveryAddressDto);
            return "redirect:/delivery-addresses";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating delivery address failed. Try again.");
        return "v1/delivery-address/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeliveryAddress(@PathVariable("id") Long id) {
        this.deliveryAddressService.delete(id);
        return "redirect:/delivery-addresses";
    }
}