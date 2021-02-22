package vn.kase.web.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.domain.v1.user.User;
import vn.kase.dto.v1.mapper.user.UserMapper;
import vn.kase.dto.v1.model.OrderDetailDto;
import vn.kase.dto.v1.model.shipping_package.PackageDto;
import vn.kase.dto.v1.model.user.UserDto;
import vn.kase.service.v1.EmailService;
import vn.kase.service.v1.OrderDetailService;
import vn.kase.service.v1.ShipperService;
import vn.kase.service.v1.shipping_package.BoxSizeService;
import vn.kase.service.v1.shipping_package.PackageService;
import vn.kase.service.v1.user.AddressService;
import vn.kase.service.v1.user.UserService;
import vn.kase.service.v1.shipping_package.WeightService;

@Controller
@RequestMapping("/orders")
public class OrderDetailController {
    private OrderDetailService orderDetailService;
    private UserService userService;
    private PackageService packageService;
    private WeightService weightService;
    private BoxSizeService boxSizeService;
    private ShipperService shipperService;
    private AddressService addressService;
    private EmailService emailService;

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

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String getOrders(Model model) {
        model.addAttribute("orderDetailList", this.orderDetailService.findAll());
        return "v1/order-detail/index";
    }

    @GetMapping("/detail")
    public String getOrderById(final Model model, final @RequestParam("id") Long id) {
        model.addAttribute("orderDetailDto", this.orderDetailService.findById(id));
        model.addAttribute("newUser", new UserDto());
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("newPackage", new PackageDto());
        model.addAttribute("packages", this.packageService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("shippers", this.shipperService.findAll());
        return "v1/order-detail/detail";
    }

    @GetMapping("/add")
    public String addOrder(Model model) {
        model.addAttribute("orderDetailDto", new OrderDetailDto());
        model.addAttribute("newUser", new UserDto());
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("newPackage", new PackageDto());
        model.addAttribute("packages", this.packageService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("shippers", this.shipperService.findAll());
        return "v1/order-detail/add";
    }

    @PostMapping("/add")
    public String addOrder(
            Model model,
            @ModelAttribute("orderDetailDto") OrderDetailDto orderDetailDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/order-detail/add";
        }

        try {
            Long shippingPackageId = orderDetailDto.getShippingPackageId();
            model.addAttribute("shippingPackageId", shippingPackageId);
            this.orderDetailService.add(orderDetailDto);
            this.emailService.sendEmailWithHtmlContent(UserMapper.toEntity(this.userService.findById(orderDetailDto.getRecipientId())).getEmail(), shippingPackageId);
            return "v1/order-detail/add-order-success";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Adding order failed. Try again.");
        return "v1/order-detail/add";
    }

    @GetMapping("/update")
    public String updateOrder(@RequestParam("id") Long id, Model model) {
        model.addAttribute("orderDetailDto", this.orderDetailService.findById(id));
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("packages", this.packageService.findAll());
        model.addAttribute("weights", this.weightService.findAll());
        model.addAttribute("boxSizes", this.boxSizeService.findAll());
        model.addAttribute("addresses", this.addressService.findAll());
        model.addAttribute("shippers", this.shipperService.findAll());
        return "v1/order-detail/update";
    }

    @PostMapping("/update")
    public String updateOrder(
            Model model,
            @ModelAttribute("orderDetailDto") OrderDetailDto orderDetailDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/order-detail/update";
        }

        try {
            this.orderDetailService.update(orderDetailDto);
            return "redirect:/orders";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating order detail failed. Try again.");
        return "v1/order-detail/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderDetail(@PathVariable("id") Long id) {
        this.orderDetailService.delete(id);
        return "redirect:/orders";
    }
}