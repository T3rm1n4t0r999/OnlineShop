package FIb3.Smekhow.OnlineShop.Service;

import FIb3.Smekhow.OnlineShop.Model.Storage;
import FIb3.Smekhow.OnlineShop.Model.Storage;
import FIb3.Smekhow.OnlineShop.Repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StorageService implements IService<Storage> {
    private final StorageRepository storageRepository;

    @Override
    public Storage create(Storage storage)
    {
        return storageRepository.save(storage);
    }

    @Override
    public Storage findById(int id)
    {
        return storageRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
    }

    @Override
    public List<Storage> findAll()
    {
        return storageRepository.findAll();
    }

    @Override
    public Storage update(int id, Storage storageDetails)
    {
        Storage storage = storageRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
        storage.setStorageCapacity(storageDetails.getStorageCapacity());
        return storageRepository.save(storage);
    }

    @Override
    public void delete(int id)
    {
        storageRepository.deleteById(id);
    }

}
