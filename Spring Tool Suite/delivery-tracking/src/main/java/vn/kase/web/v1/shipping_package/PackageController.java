package vn.kase.web.v1.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.shipping_package.PackageDto;
import vn.kase.service.v1.OrderDetailService;
import vn.kase.service.v1.shipping_package.PackageService;
import vn.kase.service.v1.UserService;

@Controller
@RequestMapping("/shipping-packages")
public class PackageController {
    private final PackageService packageService;
    private final UserService userService;
    private final OrderDetailService orderDetailService;

    @Autowired
    public PackageController(PackageService packageService, UserService userService, OrderDetailService orderDetailService) {
        this.packageService = packageService;
        this.userService = userService;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public String getPackages(Model model) {
        model.addAttribute("shippingPackages", this.packageService.findAll());
        return "v1/package/index";
    }

    @GetMapping("/add")
    public String addPackage(Model model) {
        model.addAttribute("shippingPackageDto", new PackageDto());
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("orders", this.orderDetailService.findAll());
        return "v1/package/add";
    }

    @PostMapping("/add")
    public String addPackage(
            Model model,
            @ModelAttribute("shippingPackageDto") PackageDto packageDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/package/add";
        }

        try {
            this.packageService.add(packageDto);
            return "redirect:/shipping-packages";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating user failed. Try again.");
        return "v1/package/add";
    }

    @GetMapping("/update")
    public String updatePackage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("shippingPackageDto", this.packageService.findById(id));
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("orders", this.orderDetailService.findAll());
        return "v1/package/update";
    }

    @PostMapping("/update")
    public String updatePackage(
            Model model,
            @ModelAttribute("shippingPackageDto") PackageDto packageDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/package/update";
        }

        try {
            this.packageService.update(packageDto);
            return "redirect:/shipping-packages";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating package failed. Try again.");
        return "v1/package/update";
    }

    @GetMapping("/delete/{id}")
    public String deletePackage(@PathVariable("id") Long id) {
        this.packageService.delete(id);
        return "redirect:/packages";
    }
}