package vn.kase.web.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.PackageDto;
import vn.kase.dto.v1.model.ShipperDto;
import vn.kase.service.v1.PackageService;
import vn.kase.service.v1.ShipperService;

@Controller
@RequestMapping("/shippers")
public class ShipperController {
    private final ShipperService shipperService;

    @Autowired
    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping
    public String getShippers(Model model) {
        model.addAttribute("shippers", this.shipperService.findAll());
        return "v1/shipper/index";
    }

    @GetMapping("/add")
    public String addShipper(Model model) {
        model.addAttribute("shipperDto", new ShipperDto());
        return "v1/shipper/add";
    }

    @PostMapping("/add")
    public String addShipper(
            Model model,
            @ModelAttribute("shipperDto") ShipperDto shipperDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/shipper/add";
        }

        try {
            this.shipperService.add(shipperDto);
            return "redirect:/shippers";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "v1/shipper/add";
    }

    @GetMapping("/update")
    public String updateShipper(@RequestParam("id") Long id, Model model) {
        model.addAttribute("shipperDto", this.shipperService.findById(id));
        return "v1/shipper/update";
    }

    @PostMapping("/update")
    public String updateShipper(
            Model model,
            @ModelAttribute("shipperDto") ShipperDto shipperDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/shipper/update";
        }

        try {
            this.shipperService.update(shipperDto);
            return "redirect:/shippers";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating shipper failed. Try again.");
        return "v1/shipper/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteShipper(@PathVariable("id") Long id) {
        this.shipperService.delete(id);
        return "redirect:/shippers";
    }
}