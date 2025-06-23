package FIb3.Smekhow.OnlineShop.Controller;

import FIb3.Smekhow.OnlineShop.Model.Purchase;
import FIb3.Smekhow.OnlineShop.Service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/purchases")
public class PurchaseController implements IController<Purchase>{
    private final PurchaseService purchaseService;

    @Operation(summary = "getAllPurchases")
    @GetMapping
    @Override
    public ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.findAll());
    }

    @Operation(summary = "getPurchaseById")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Purchase> getById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.findById(id));
    }

    @Operation(summary = "createPurchase")
    @PostMapping
    private ResponseEntity<Purchase> create(@RequestBody Purchase purchase) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.create(purchase));
    }

    @Operation(summary = "updatePurchase")
    @PutMapping("/{id}")
    private ResponseEntity<Purchase> update(@PathVariable int id,@RequestBody Purchase purchase) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.update(id, purchase));
    }

    @Operation(summary = "deletePurchase")
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id) {
        purchaseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
