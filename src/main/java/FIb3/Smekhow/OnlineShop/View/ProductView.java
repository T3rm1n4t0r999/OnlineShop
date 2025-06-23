package FIb3.Smekhow.OnlineShop.View;

import FIb3.Smekhow.OnlineShop.Model.Product;
import FIb3.Smekhow.OnlineShop.Model.Product;
import FIb3.Smekhow.OnlineShop.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductView implements IView<Product> {
    private final ProductService productService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create-product";
    }

    @PostMapping
    public String create(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view-product";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit-product";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute Product productDetails) {
        productService.update(id, productDetails);
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
