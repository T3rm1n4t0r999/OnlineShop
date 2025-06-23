package FIb3.Smekhow.OnlineShop.Controller;

import FIb3.Smekhow.OnlineShop.Model.Product;
import FIb3.Smekhow.OnlineShop.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController implements IController<Product> {

    private final ProductService productService;

    @Operation(summary = "getAllProducts")
    @GetMapping
    @Override
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @Operation(summary = "getProductById")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Product> getById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @Operation(summary = "createProduct")
    @PostMapping
    private ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.create(product));
    }

    @Operation(summary = "updateProduct")
    @PutMapping("/{id}")
    private ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, product));
    }

    @Operation(summary = "deleteProduct")
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
