package FIb3.Smekhow.OnlineShop.Service;

import FIb3.Smekhow.OnlineShop.Model.Purchase;
import FIb3.Smekhow.OnlineShop.Repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService implements IService<Purchase>{
    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase create(Purchase purchase)
    {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findById(int id)
    {
        return purchaseRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
    }

    @Override
    public List<Purchase> findAll()
    {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase update(int id, Purchase purchaseDetails)
    {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
        purchase.setCustomerID(purchaseDetails.getCustomerID());
        purchase.setPayType(purchaseDetails.getPayType());
        return purchaseRepository.save(purchase);
    }

    @Override
    public void delete(int id)
    {
        purchaseRepository.deleteById(id);
    }

}
