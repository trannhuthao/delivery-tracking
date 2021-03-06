package vn.kase.web.v1.shipping_package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.kase.dto.v1.model.shipping_package.BoxSizeDto;
import vn.kase.service.v1.shipping_package.BoxSizeService;

@Controller
@RequestMapping("/box-sizes")
public class BoxSizeController {
    private final BoxSizeService boxSizeService;

    @Autowired
    public BoxSizeController(BoxSizeService boxSizeService) {
        this.boxSizeService = boxSizeService;
    }

    @GetMapping
    public String getBoxSizes(Model model) {
//        model.addAttribute("boxSizes", this.boxSizeService.findAll());
//        return "v1/package/box-sizes/index";

    	return this.getBoxSizesPaginated(1, "boxSize", "asc", model);
    }
    
    @GetMapping("/{page}")
    public String getBoxSizesPaginated(
            final @PathVariable("page") int page,
            final @RequestParam("sortField") String sortField,
            final @RequestParam("sortDirection") String sortDirection,
            final Model model
    ) {
    	int size = 5;
    	Page<BoxSizeDto> boxSizesPaginated = this.boxSizeService.findAllPaginated(page, size, sortField, sortDirection);
    	List<BoxSizeDto> boxSizes = boxSizesPaginated.getContent();

    	 model.addAttribute("currentPage", page);
         model.addAttribute("totalPages", boxSizesPaginated.getTotalPages());
         model.addAttribute("totalElements", boxSizesPaginated.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
         model.addAttribute("boxSizes", boxSizes);

    	return "v1/package/box-sizes/index";
    }

    @GetMapping("/detail")
    public String getBoxSizeById(final Model model, final @RequestParam("id") Long id) {
        model.addAttribute("boxSizeDto", this.boxSizeService.findById(id));
        return "v1/package/box-sizes/detail";
    }

    @GetMapping("/add")
    public String addBoxSize(Model model) {
        model.addAttribute("boxSizeDto", new BoxSizeDto());
        return "v1/package/box-sizes/add";
    }

    @PostMapping("/add")
    public String addBoxSize(
            Model model,
            @ModelAttribute("boxSizeDto") BoxSizeDto boxSizeDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/package/box-sizes/add";
        }

        try {
            this.boxSizeService.add(boxSizeDto);
            return "redirect:/box-sizes";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Adding box size failed. Try again.");
        return "v1/package/box-sizes/add";
    }

    @GetMapping("/update")
    public String updateBoxSize(@RequestParam("id") Long id, Model model) {
        model.addAttribute("boxSizeDto", this.boxSizeService.findById(id));
        return "v1/package/box-sizes/update";
    }

    @PostMapping("/update")
    public String updateBoxSize(
            Model model,
            @ModelAttribute("boxSizeDto") BoxSizeDto boxSizeDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "v1/package/box-sizes/update";
        }

        try {
            this.boxSizeService.update(boxSizeDto);
            return "redirect:/box-sizes";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        model.addAttribute("errorMessage", "Updating box size failed. Try again.");
        return "v1/package/box-sizes/update";
    }

    @GetMapping("/delete/{id}")
    public String deleteBoxSize(@PathVariable("id") Long id) {
        this.boxSizeService.delete(id);
        return "redirect:/box-sizes";
    }
}