package vn.kase.web.v1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.user.AddressDto;
import vn.kase.service.v1.user.AddressService;

@Controller
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public String getAddresses(Model model) {
        model.addAttribute("addresses", this.addressService.findAll());
        return "v1/address/index";
    }

    @GetMapping("/add")
    public String addAddress(Model model) {
        model.addAttribute("addressDto", new AddressDto());
        return "v1/address/add";
    }

    @PostMapping("/add")
    public String addAddress(
            Model model,
            @ModelAttribute("addressDto") AddressDto addressDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/address/add";
        }

        try {
            this.addressService.add(addressDto);
            return "redirect:/addresses";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating address failed. Try again.");
        return "v1/address/add";
    }

    @GetMapping("/update")
    public String updateAddress(@RequestParam("id") Long id, Model model) {
        model.addAttribute("addressDto", this.addressService.findById(id));
        return "v1/address/update";
    }

    @PostMapping("/update")
    public String updateAddress(
            Model model,
            @ModelAttribute("addressDto") AddressDto addressDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/address/update";
        }

        try {
            this.addressService.update(addressDto);
            return "redirect:/addresses";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating address failed. Try again.");
        return "v1/address/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable("id") Long id) {
        this.addressService.delete(id);
        return "redirect:/addresses";
    }
}