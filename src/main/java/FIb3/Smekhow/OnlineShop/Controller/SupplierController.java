package FIb3.Smekhow.OnlineShop.Controller;

import FIb3.Smekhow.OnlineShop.Model.Supplier;
import FIb3.Smekhow.OnlineShop.Repository.SupplierRepository;
import FIb3.Smekhow.OnlineShop.Service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suppliers")
public class SupplierController implements IController<Supplier> {
    
    private final SupplierService supplierService;
    
    @Operation(summary = "getAllSuppliers")
    @GetMapping
    @Override
    public ResponseEntity<List<Supplier>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.findAll());
    }
    
    @Operation(summary = "getSupplierById")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Supplier> getById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.findById(id));
    }
    
    @Operation(summary = "createSupplier")
    @PostMapping
    private ResponseEntity<Supplier> create(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.create(supplier));
    }
    
    @Operation(summary = "updateSupplier")
    @PutMapping("/{id}")
    private ResponseEntity<Supplier> update(@PathVariable int id, @RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.update(id, supplier));
    }
    
    @Operation(summary = "deleteSupplier")
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id) {
        supplierService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
