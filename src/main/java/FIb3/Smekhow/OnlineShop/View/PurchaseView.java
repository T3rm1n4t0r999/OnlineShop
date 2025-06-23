package FIb3.Smekhow.OnlineShop.View;

import FIb3.Smekhow.OnlineShop.Model.Purchase;
import FIb3.Smekhow.OnlineShop.Model.Purchase;
import FIb3.Smekhow.OnlineShop.Service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/purchases")
public class PurchaseView implements IView<Purchase>{
    private final PurchaseService purchaseService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("purchases", purchaseService.findAll());
        return "purchases";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create-purchase";
    }

    @PostMapping
    public String create(@ModelAttribute Purchase purchase) {
        purchaseService.create(purchase);
        return "redirect:/purchases";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("purchase", purchaseService.findById(id));
        return "view-purchase";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("purchase", purchaseService.findById(id));
        return "edit-purchase";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute Purchase purchaseDetails) {
        purchaseService.update(id, purchaseDetails);
        return "redirect:/purchases";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        purchaseService.delete(id);
        return "redirect:/purchases";
    }
}
