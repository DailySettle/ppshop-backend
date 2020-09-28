package mingli.ppshop.controller;

import mingli.ppshop.datatypes.CATEGORY;
import mingli.ppshop.entity.Product;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @GetMapping("")
    public Product[] getAllProducts() {
        return new Product[]{
                new Product("Haribo 1", CATEGORY.A, "Happy Cola 200g", 0.97, 2, "https://onlineshop.haribo.com/media/image/e1/c0/b0/Happy-Cola-200-g_40016863151015b895bc20632e_260x260.png"),
                new Product("Haribo 2", CATEGORY.A, "Saft Gold 175g", 0.87, 2, "https://onlineshop.haribo.com/media/image/a9/dd/86/Saft_GB_175g-jpg_260x260.png"),
                new Product("Haribo 3", CATEGORY.A, "Pico Balla 175g", 0.88, 2, "https://onlineshop.haribo.com/media/image/55/83/b3/Pico-Balla-175-g_8426617106201_260x260.png")};
    }
}
