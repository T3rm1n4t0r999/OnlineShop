package FIb3.Smekhow.OnlineShop.Controller;

import FIb3.Smekhow.OnlineShop.Model.Customer;
import FIb3.Smekhow.OnlineShop.Service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController implements IController<Customer> {
    private final CustomerService customerService;

    @Operation(summary = "getAllCustomers")
    @GetMapping
    @Override
    public ResponseEntity<List<Customer>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }

    @Operation(summary = "getCustomerById")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Customer> getById(@PathVariable int id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }

    @Operation(summary = "createCustomer")
    @PostMapping
    private ResponseEntity<Customer> create(@RequestBody Customer customer)
    {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.create(customer));
    }

    @Operation(summary = "updateCustomer")
    @PutMapping("/{id}")
    private ResponseEntity<Customer> update(@PathVariable int id, @RequestBody Customer customer)
    {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(id, customer));
    }

    @Operation(summary = "deleteCustomer")
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id)
    {
        customerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
