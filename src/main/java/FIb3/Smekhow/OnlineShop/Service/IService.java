package FIb3.Smekhow.OnlineShop.Service;

import java.util.List;

public interface IService<T> {
    T create(T model);
    T findById(int id);
    List<T> findAll();
    T update(int id, T details);
    void delete(int id);
}
