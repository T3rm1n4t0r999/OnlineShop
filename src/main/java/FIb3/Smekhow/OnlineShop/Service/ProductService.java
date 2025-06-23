package FIb3.Smekhow.OnlineShop.Service;

import FIb3.Smekhow.OnlineShop.Model.Product;
import FIb3.Smekhow.OnlineShop.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements IService<Product> {
    private final ProductRepository productRepository;

    @Override
    public Product create(Product product)
    {
        return productRepository.save(product);
    }

    @Override
    public Product findById(int id)
    {
        return productRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
    }

    @Override
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Product update(int id, Product productDetails)
    {
        Product product = productRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
        product.setProductName(productDetails.getProductName());
        product.setProductDescription(productDetails.getProductDescription());
        product.setProductPrice(productDetails.getProductPrice());
        product.setProductAmount(productDetails.getProductAmount());
        return productRepository.save(product);
    }

    @Override
    public void delete(int id)
    {
        productRepository.deleteById(id);
    }

}
