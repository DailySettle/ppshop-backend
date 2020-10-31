package mingli.ppshop.dao;

import mingli.ppshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ProductDao extends JpaRepository<Product, UUID>, JpaSpecificationExecutor<Product> {

}
