package mingli.ppshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mingli.ppshop.datatypes.ProductCategory;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

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
}
