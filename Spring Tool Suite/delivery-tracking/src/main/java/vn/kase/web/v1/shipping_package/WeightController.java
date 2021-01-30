package vn.kase.web.v1.shipping_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.domain.v1.shipping_package.Weight;
import vn.kase.dto.v1.model.shipping_package.WeightDto;
import vn.kase.service.v1.shipping_package.WeightService;

@Controller
@RequestMapping("/weights")
public class WeightController {
    private final WeightService weightService;

    @Autowired
    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping
    public String getWeights(Model model) {
        model.addAttribute("weights", this.weightService.findAll());
        return "v1/weights/index";
    }

    @GetMapping("/add")
    public String addWeights(Model model) {
        model.addAttribute("weightDto", new Weight());
        return "v1/weights/add";
    }

    @PostMapping("/add")
    public String addWeights(
            Model model,
            @ModelAttribute("weightDto") WeightDto weightDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/weights/add";
        }

        try {
            this.weightService.add(weightDto);
            return "redirect:/weights";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Adding weight failed. Try again.");
        return "v1/weights/add";
    }

    @GetMapping("/update")
    public String updateWeight(@RequestParam("id") Long id, Model model) {
        model.addAttribute("weight", this.weightService.findById(id));
        return "v1/weights/update";
    }

    @PostMapping("/update")
    public String updateWeight(
            Model model,
            @ModelAttribute("weightDto") WeightDto weightDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/weights/update";
        }

        try {
            this.weightService.update(weightDto);
            return "redirect:/weights";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating weight failed. Try again.");
        return "v1/weights/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteWeight(@PathVariable("id") Long id) {
        this.weightService.delete(id);
        return "redirect:/weights";
    }
}