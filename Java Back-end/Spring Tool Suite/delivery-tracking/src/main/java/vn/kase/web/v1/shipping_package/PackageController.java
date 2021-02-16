package vn.kase.web.v1.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.shipping_package.PackageDto;
import vn.kase.service.v1.OrderDetailService;
import vn.kase.service.v1.shipping_package.BoxSizeService;
import vn.kase.service.v1.shipping_package.PackageService;
import vn.kase.service.v1.shipping_package.WeightService;
import vn.kase.service.v1.user.AddressService;
import vn.kase.service.v1.user.UserService;

@Controller
@RequestMapping("/shipping-packages")
public class PackageController {
    private PackageService packageService;
    private UserService userService;
    private AddressService addressService;
    private OrderDetailService orderDetailService;
    private WeightService weightService;
    private BoxSizeService boxSizeService;

    @Autowired
    public void setPackageService(final PackageService packageService) {
        this.packageService = packageService;
    }

    @Autowired
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAddressService(final AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    public void setOrderDetailService(final OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @Autowired
    public void setWeightService(final WeightService weightService) {
        this.weightService = weightService;
    }

    @Autowired
    public void setBoxSizeService(final BoxSizeService boxSizeService) {
        this.boxSizeService = boxSizeService;
    }

    @GetMapping
    public String getPackages(final Model model) {
        model.addAttribute("shippingPackages", this.packageService.findAll());
        return "v1/package/index";
    }

    @GetMapping("/detail")
    public String getPackageById(final Model model, final @RequestParam("id") Long id) {
        model.addAttribute("shippingPackageDto", this.packageService.findById(id));
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("orders", this.orderDetailService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        return "v1/package/detail";
    }

    @GetMapping("/add")
    public String addPackage(final Model model) {
        model.addAttribute("shippingPackageDto", new PackageDto());
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("orders", this.orderDetailService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        return "v1/package/add";
    }

    @PostMapping("/add")
    public String addPackage(
            final Model model,
            final @ModelAttribute("shippingPackageDto") PackageDto packageDto,
            final BindingResult bindingResult
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
    public String updatePackage(final @RequestParam("id") Long id, final Model model) {
        model.addAttribute("shippingPackageDto", this.packageService.findById(id));
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("orders", this.orderDetailService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        return "v1/package/update";
    }

    @PostMapping("/update")
    public String updatePackage(
            final Model model,
            final @ModelAttribute("shippingPackageDto") PackageDto packageDto,
            final BindingResult bindingResult
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
    public String deletePackage(final @PathVariable("id") Long id) {
        this.packageService.delete(id);
        return "redirect:/shipping-packages";
    }
}