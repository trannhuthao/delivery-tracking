package vn.kase.web.v1.shipping_package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String getWeightRanges(Model model) {
//        model.addAttribute("weights", this.weightService.findAll());
//        return "v1/package/weights/index";
    	
    	return this.getWeightRangesPaginated(1, model);
    }

    @GetMapping("/{page}")
    public String getWeightRangesPaginated(final @PathVariable("page") int page, final Model model) {
    	int size = 5;
    	Page<WeightDto> weightsPaginated = this.weightService.findAllPaginated(page, size);
    	List<WeightDto> weights = weightsPaginated.getContent();

    	model.addAttribute("currentPage", page);
    	model.addAttribute("totalPages", weightsPaginated.getTotalPages());
    	model.addAttribute("totalElements", weightsPaginated.getTotalElements());
    	model.addAttribute("weights", weights);

    	return "v1/package/weights/index";
    }

    @GetMapping("/detail")
    public String getWeightRangeById(final Model model, final @RequestParam("id") Long id) {
        model.addAttribute("weightDto", this.weightService.findById(id));
        return "v1/package/weights/detail";
    }

    @GetMapping("/add")
    public String addWeight(Model model) {
        model.addAttribute("weightDto", new WeightDto());
        return "v1/package/weights/add";
    }

    @PostMapping("/add")
    public String addWeightRange(
            Model model,
            @ModelAttribute("weightDto") WeightDto weightDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/package/weights/add";
        }

        try {
            this.weightService.add(weightDto);
            return "redirect:/weights";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Add new weight range failed. Try again.");
        return "v1/package/weights/add";
    }

    @GetMapping("/update")
    public String updateWeight(@RequestParam("id") Long id, Model model) {
        model.addAttribute("weightDto", this.weightService.findById(id));
        return "v1/package/weights/update";
    }

    @PostMapping("/update")
    public String updateWeight(
            Model model,
            @ModelAttribute("weightDto") WeightDto weightDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/package/weights/update";
        }

        try {
            this.weightService.update(weightDto);
            return "redirect:/weights";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating weight failed. Try again.");
        return "v1/package/weights/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteWeight(@PathVariable("id") Long id) {
        this.weightService.delete(id);
        return "redirect:/weights";
    }
}