package vn.kase.web.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "v1/home/index";
    }

    @GetMapping("swagger")
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }
}