package FIb3.Smekhow.OnlineShop.Controller;

import FIb3.Smekhow.OnlineShop.Model.Storage;
import FIb3.Smekhow.OnlineShop.Service.StorageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storages")
public class StorageController implements IController<Storage> {
    
    private final StorageService storageService;
    
    @Operation(summary = "getAllStorages")
    @GetMapping
    @Override
    public ResponseEntity<List<Storage>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.findAll());
    }

    @Operation(summary = "getStorageById")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Storage> getById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.findById(id));
    }
    
    @Operation(summary = "createStorage")
    @PostMapping
    private ResponseEntity<Storage> create(@RequestBody Storage storage) {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.create(storage));
    }

    @Operation(summary = "updateStorage")
    @PutMapping("/{id}")
    private ResponseEntity<Storage> update(@PathVariable int id, @RequestBody Storage storage) {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.update(id, storage));
    }

    @Operation(summary = "deleteStorage")
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id) {
        storageService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
