package ma.projet;

import ma.projet.entities.Product;
import ma.projet.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    // GET tous les produits
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET un produit par id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    // POST ajouter un produit
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // PUT mettre a jour un produit
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    // DELETE supprimer un produit
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}