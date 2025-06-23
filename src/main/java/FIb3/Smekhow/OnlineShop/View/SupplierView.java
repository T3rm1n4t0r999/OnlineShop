package FIb3.Smekhow.OnlineShop.View;

import FIb3.Smekhow.OnlineShop.Model.Supplier;
import FIb3.Smekhow.OnlineShop.Service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/suppliers")
public class SupplierView implements IView<Supplier> {
    private final SupplierService supplierService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "suppliers";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create-supplier";
    }

    @PostMapping
    public String create(@ModelAttribute Supplier supplier) {
        supplierService.create(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("supplier", supplierService.findById(id));
        return "view-supplier";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("supplier", supplierService.findById(id));
        return "edit-supplier";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute Supplier supplierDetails) {
        supplierService.update(id, supplierDetails);
        return "redirect:/suppliers";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
