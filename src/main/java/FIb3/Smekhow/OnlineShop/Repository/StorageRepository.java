package FIb3.Smekhow.OnlineShop.Repository;

import FIb3.Smekhow.OnlineShop.Model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer>{
}
