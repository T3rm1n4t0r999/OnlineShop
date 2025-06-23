package FIb3.Smekhow.OnlineShop.View;

import FIb3.Smekhow.OnlineShop.Model.Storage;
import FIb3.Smekhow.OnlineShop.Model.Storage;
import FIb3.Smekhow.OnlineShop.Service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/storages")
public class StorageView implements IView<Storage> {
    private final StorageService storageService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("storages", storageService.findAll());
        return "storages";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create-storage";
    }

    @PostMapping
    public String create(@ModelAttribute Storage storage) {
        storageService.create(storage);
        return "redirect:/storages";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("storage", storageService.findById(id));
        return "view-storage";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("storage", storageService.findById(id));
        return "edit-storage";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute Storage storageDetails) {
        storageService.update(id, storageDetails);
        return "redirect:/storages";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        storageService.delete(id);
        return "redirect:/storages";
    }
}
