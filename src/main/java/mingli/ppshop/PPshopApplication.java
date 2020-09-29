package mingli.ppshop;

import mingli.ppshop.datatypes.CATEGORY;
import mingli.ppshop.entity.Product;
import mingli.ppshop.entity.User;
import mingli.ppshop.repository.ProductRepository;
import mingli.ppshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PPshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PPshopApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner init(ProductRepository productRepository, UserRepository userRepository) {
        Product product1 = new Product("Haribo 1", CATEGORY.A, "Happy Cola 200g", 0.97, 2, "https://onlineshop.haribo.com/media/image/e1/c0/b0/Happy-Cola-200-g_40016863151015b895bc20632e_260x260.png");
        Product product2 = new Product("Haribo 2", CATEGORY.A, "Saft Gold 175g", 0.87, 2, "https://onlineshop.haribo.com/media/image/a9/dd/86/Saft_GB_175g-jpg_260x260.png");
        Product product3 = new Product("Haribo 3", CATEGORY.A, "Pico Balla 175g", 0.88, 2, "https://onlineshop.haribo.com/media/image/55/83/b3/Pico-Balla-175-g_8426617106201_260x260.png");
        User user = new User("ming@test", "password", true, "ROLE_USER");

        return args -> {
            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            userRepository.save(user);
        };
    }

}
