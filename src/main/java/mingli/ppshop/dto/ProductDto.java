package mingli.ppshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mingli.ppshop.datatypes.CATEGORY;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;
    private CATEGORY category;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
}
