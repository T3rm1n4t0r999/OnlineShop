package FIb3.Smekhow.OnlineShop.View;

import FIb3.Smekhow.OnlineShop.Model.Customer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public interface IView<T> {

    String getAll(Model model);

    String showCreateForm();

    String create(T model);

    String get(int id, Model model);

    String showEditForm( int id, Model model);

    String update(int id, T customerDetails);

    String delete(int id);
}
