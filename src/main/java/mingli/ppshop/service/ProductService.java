package mingli.ppshop.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import mingli.ppshop.dao.ProductDao;
import mingli.ppshop.dto.ProductDto;
import mingli.ppshop.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Log
public class ProductService {

    private final ProductDao productDao;

    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return productDao.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDto findById(UUID id) {
        return productDao.findById(id)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .orElse(null);
    }


    public void save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product.setId(UUID.randomUUID());
        productDao.save(product);
        log.info("New product is saved with id " + product.getId());
    }


    public void update(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productDao.save(product);
        log.info("Product with id " + product.getId() + "is updated");
    }

    public void deleteById(UUID id) {
        productDao.deleteById(id);
        log.info("Product with id " + id + "is deleted");
    }


    /**
     * 按条件查询
     *
     * @param productDto
     * @return
     */
    public List<ProductDto> findSearch(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return productDao.findAll(searchMap(product)).stream()
                .map(one -> modelMapper.map(one, ProductDto.class))
                .collect(Collectors.toList());
    }

    /**
     * 分页查询
     *
     * @param productDto
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<ProductDto> pageQuery(ProductDto productDto, int currentPage, int pageSize) {
        Product product = modelMapper.map(productDto, Product.class);
        return productDao.findAll(searchMap(product), PageRequest.of(currentPage - 1, pageSize))
                .map(one -> modelMapper.map(one, ProductDto.class));
    }

    /**
     * 封装查询对象
     *
     * @param product
     * @return
     */
    private Specification<Product> searchMap(Product product) {
        return (Specification<Product>) (root, query, cb) -> {
            List<Predicate> list = new LinkedList<>();
            if (!StringUtils.isEmpty(product.getName())) {
                Predicate productname = cb.like(root.get("name").as(String.class), "%" + product.getName() + "%");
                list.add(productname);
            }
            if (!StringUtils.isEmpty(product.getCategory())) {
                Predicate state = cb.equal(root.get("category").as(Integer.class), product.getCategory().getCode());
                list.add(state);
            }
            Predicate[] array = new Predicate[list.size()];
            array = list.toArray(array);
            return cb.and(array);
        };
    }
}
