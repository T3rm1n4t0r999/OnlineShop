package FIb3.Smekhow.OnlineShop.Controller;

import FIb3.Smekhow.OnlineShop.Model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IController<T> {
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getById(int id);

    private ResponseEntity<T> create(T model) {
        return null;
    }

    private ResponseEntity<T> update(int id, T model) {
        return null;
    }

    private ResponseEntity<Void> delete(int id) {
        return null;
    }
}
