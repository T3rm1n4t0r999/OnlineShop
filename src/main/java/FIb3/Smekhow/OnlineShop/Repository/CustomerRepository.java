package FIb3.Smekhow.OnlineShop.Repository;

import FIb3.Smekhow.OnlineShop.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
