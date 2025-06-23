package FIb3.Smekhow.OnlineShop.Repository;

import FIb3.Smekhow.OnlineShop.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
