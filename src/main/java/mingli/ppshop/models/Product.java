package mingli.ppshop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mingli.ppshop.datatypes.CATEGORY;

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
    private CATEGORY category;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;

    public Product(String name, CATEGORY category, String description, double price, int quantity, String imageUrl) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

}
