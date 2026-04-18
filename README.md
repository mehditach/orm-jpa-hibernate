# TP2 - ORM JPA Hibernate Spring Data

## description
ce tp on a vu comment utiliser JPA et Hibernate avec Spring Data pour gerer une base de donnees

## ce qu'on a fait

1. creer un projet spring initializr avec les dependances : JPA, H2, Spring Web, Lombok
2. creer l'entite Product avec les attributs id, name, price, quantity
3. configurer application.properties
4. creer l'interface ProductRepository qui extends JpaRepository
5. tester les operations CRUD :
   - ajouter des produits
   - consulter tous les produits
   - consulter un produit par id
   - chercher des produits
   - mettre a jour un produit
   - supprimer un produit

## technologies
- Java 17
- Spring Boot
- JPA / Hibernate
- H2 Database
- Lombok
- Maven

## lancer le projet
```
mvnw spring-boot:run
```