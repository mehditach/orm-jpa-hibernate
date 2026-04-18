package ma.projet;

import ma.projet.entities.Product;
import ma.projet.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmJpaHibernateApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Ajouter
        productRepository.save(new Product(null, "PC Dell", 8500.0, 10));
        productRepository.save(new Product(null, "iPhone 15", 12000.0, 5));
        productRepository.save(new Product(null, "Clavier", 350.0, 50));

        // Consulter tous
        System.out.println("=== Tous les produits ===");
        productRepository.findAll().forEach(System.out::println);

        // Consulter un
        System.out.println("=== Produit ID=1 ===");
        productRepository.findById(1L).ifPresent(System.out::println);

        // Chercher
        System.out.println("=== Chercher PC Dell ===");
        productRepository.findByName("PC Dell").forEach(System.out::println);

        // Mettre à jour
        Product p = productRepository.findById(1L).orElseThrow();
        p.setPrice(7500.0);
        productRepository.save(p);
        System.out.println("Mis à jour : " + p);

        // Supprimer
        productRepository.deleteById(3L);
        System.out.println("Produit supprimé !");
    }
}