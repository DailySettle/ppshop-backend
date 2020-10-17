package mingli.ppshop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mingli.ppshop.datatypes.CATEGORY;
import mingli.ppshop.dto.ProductDto;

import javax.persistence.Column;
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
    private boolean isNewArrive;
    private boolean isOnSale;

    public Product(String name, CATEGORY category, String description, double price, int quantity, String imageUrl, boolean isNewArrive, boolean isOnSale) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.isNewArrive = isNewArrive;
        this.isOnSale = isOnSale;
    }
}
