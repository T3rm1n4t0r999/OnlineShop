package FIb3.Smekhow.OnlineShop.Repository;

import FIb3.Smekhow.OnlineShop.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
}
