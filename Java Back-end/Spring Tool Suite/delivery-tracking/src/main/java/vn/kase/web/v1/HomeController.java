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

    @GetMapping("/about")
    public String about() {
        return "v1/home/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "v1/home/contact";
    }

    @GetMapping("/404")
    public String http404NotFound() {
        return "v1/error-pages/404";
    }

    @GetMapping("/403")
    public String http403Forbidden() {
        return "v1/error-pages/403";
    }
}