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

}
