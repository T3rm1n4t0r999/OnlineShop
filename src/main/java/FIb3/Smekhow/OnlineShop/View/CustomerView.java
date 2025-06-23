package FIb3.Smekhow.OnlineShop.View;

import FIb3.Smekhow.OnlineShop.Model.Customer;
import FIb3.Smekhow.OnlineShop.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerView implements IView<Customer> {

    private final CustomerService customerService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create-customer";
    }

    @PostMapping
    public String create(@ModelAttribute Customer customer) {
        customerService.create(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view-customer";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit-customer";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute Customer customerDetails) {
        customerService.update(id, customerDetails);
        return "redirect:/customers";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
