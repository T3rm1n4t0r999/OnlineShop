package FIb3.Smekhow.OnlineShop.Repository;

import FIb3.Smekhow.OnlineShop.Model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
}
