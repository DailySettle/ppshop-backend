package mingli.ppshop.datatypes;
import lombok.Getter;

@Getter
public enum ProductCategory {
    FAST_FOOD(1),
    VEGES(2),
    CANDY(3);

    private final Integer code;

    ProductCategory(Integer code) {
        this.code = code;
    }
}
