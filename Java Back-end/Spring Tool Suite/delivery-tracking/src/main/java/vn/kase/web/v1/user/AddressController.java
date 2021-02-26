package vn.kase.web.v1.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.user.AddressDto;
import vn.kase.service.v1.user.AddressService;
import vn.kase.service.v1.user.UserService;

@Controller
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    private final UserService userService;

    @Autowired
    public AddressController(AddressService addressService, UserService userService) {
        this.addressService = addressService;
        this.userService = userService;
    }

    @GetMapping
    public String getAddresses(Model model) {
//        model.addAttribute("addresses", this.addressService.findAll());
//        return "v1/address/index";
    	
    	return this.getAddressesPaginated(1, "address", "asc", model);
    }
    
    @GetMapping("/{page}")
    public String getAddressesPaginated(
            final @PathVariable("page") int page,
            final @RequestParam("sortField") String sortField,
            final @RequestParam("sortDirection") String sortDirection,
            final Model model
    ) {
		int size = 5;
    	Page<AddressDto> addressesPaginated = this.addressService.findAllPaginated(page, size, sortField, sortDirection);
    	List<AddressDto> addresses = addressesPaginated.getContent();
    	
    	model.addAttribute("currentPage", page);
    	model.addAttribute("totalPages", addressesPaginated.getTotalPages());
        model.addAttribute("totalElements", addressesPaginated.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("addresses", addresses);

        return "v1/address/index";
    }

    @GetMapping("/detail")
    public String getAddressById(final Model model, final @RequestParam("id") Long id) {
        model.addAttribute("addressDto", this.addressService.findById(id));
        return "v1/address/detail";
    }

    @GetMapping("/add")
    public String addAddress(Model model) {
        model.addAttribute("addressDto", new AddressDto());
        model.addAttribute("users", this.userService.findAll());
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
        model.addAttribute("users", this.userService.findAll());
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