package FIb3.Smekhow.OnlineShop.Service;

import FIb3.Smekhow.OnlineShop.Model.Supplier;
import FIb3.Smekhow.OnlineShop.Model.Supplier;
import FIb3.Smekhow.OnlineShop.Repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SupplierService implements IService<Supplier> {
    private final SupplierRepository supplierRepository;

    @Override
    public Supplier create(Supplier supplier)
    {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier findById(int id)
    {
        return supplierRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
    }

    @Override
    public List<Supplier> findAll()
    {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier update(int id, Supplier supplierDetails)
    {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
        supplier.setSupplierName(supplierDetails.getSupplierName());
        supplier.setSupplierPhone(supplierDetails.getSupplierPhone());
        return supplierRepository.save(supplier);
    }

    @Override
    public void delete(int id)
    {
        supplierRepository.deleteById(id);
    }

}
