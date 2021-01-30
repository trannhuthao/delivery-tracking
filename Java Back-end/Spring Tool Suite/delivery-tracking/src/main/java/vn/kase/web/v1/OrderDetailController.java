package vn.kase.web.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.OrderDetailDto;
import vn.kase.service.v1.OrderDetailService;
import vn.kase.service.v1.ShipperService;
import vn.kase.service.v1.shipping_package.BoxSizeService;
import vn.kase.service.v1.shipping_package.PackageService;
import vn.kase.service.v1.UserService;
import vn.kase.service.v1.shipping_package.WeightService;

@Controller
@RequestMapping("/orders-detail")
public class OrderDetailController {
    private OrderDetailService orderDetailService;
    private UserService userService;
    private PackageService packageService;
    private WeightService weightService;
    private BoxSizeService boxSizeService;
    private ShipperService shipperService;

    @Autowired
    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPackageService(PackageService packageService) {
        this.packageService = packageService;
    }

    @Autowired
    public void setWeightService(WeightService weightService) {
        this.weightService = weightService;
    }

    @Autowired
    public void setBoxSizeService(BoxSizeService boxSizeService) {
        this.boxSizeService = boxSizeService;
    }

    @Autowired
    public void setShipperService(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping
    public String getOrderDetailList(Model model) {
        model.addAttribute("orderDetailList", this.orderDetailService.findAll());
        return "v1/order-detail/index";
    }

    @GetMapping("/add")
    public String addOrderDetail(Model model) {
        model.addAttribute("orderDetailDto", new OrderDetailDto());
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("packages", this.packageService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        model.addAttribute("shippers", this.shipperService.findAll());
        return "v1/order-detail/add";
    }

    @PostMapping("/add")
    public String addOrderDetail(
            Model model,
            @ModelAttribute("orderDetailDto") OrderDetailDto orderDetailDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/order-detail/add";
        }

        try {
            this.orderDetailService.add(orderDetailDto);
            return "redirect:/orders-detail";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Adding order detail failed. Try again.");
        return "v1/order-detail/add";
    }

    @GetMapping("/update")
    public String updateOrderDetail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("orderDetailDto", this.orderDetailService.findById(id));
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("packages", this.packageService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        model.addAttribute("shippers", this.shipperService.findAll());
        return "v1/order-detail/update";
    }

    @PostMapping("/update")
    public String updateOrderDetail(
            Model model,
            @ModelAttribute("orderDetailDto") OrderDetailDto orderDetailDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/order-detail/update";
        }

        try {
            this.orderDetailService.update(orderDetailDto);
            return "redirect:/orders-detail";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating order detail failed. Try again.");
        return "v1/order-detail/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderDetail(@PathVariable("id") Long id) {
        this.orderDetailService.delete(id);
        return "redirect:/orders-detail";
    }
}