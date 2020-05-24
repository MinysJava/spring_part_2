package spring.part_2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.part_2.service.ProductService;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class IndexController {

    private final ProductService productService;

    @Autowired
    public IndexController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public String index(@RequestParam(value = "page") Optional<Integer> page,
                        @RequestParam(value = "size") Optional<Integer> size,
                        Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products_array", productService.findAll(PageRequest.of(page.orElse(1) -1, size.orElse(10))));
        return "index";
    }
}
