package mingli.ppshop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mingli.ppshop.datatypes.ProductCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private ProductCategory category;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    private boolean isNewArrive;
    private boolean isOnSale;
    private double rating;

    public Product(String name, ProductCategory category, String description, double price, int quantity, String imageUrl, boolean isNewArrive, boolean isOnSale, double rating) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.isNewArrive = isNewArrive;
        this.isOnSale = isOnSale;
        this.rating = rating;
    }
}
