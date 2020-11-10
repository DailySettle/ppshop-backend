package mingli.ppshop.controller;

import lombok.AllArgsConstructor;
import mingli.ppshop.dto.ProductDto;
import mingli.ppshop.service.ProductService;
import mingli.ppshop.util.PageResult;
import mingli.ppshop.util.Result;
import mingli.ppshop.util.StatusCode;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@CrossOrigin()
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public Result findAll() {
        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "查询成功", productService.findAll());
    }

    @GetMapping("/{productId}")
    public Result findById(@PathVariable("productId") UUID id) {
        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "查询成功", productService.findById(id));
    }

    @PostMapping
    public Result save(@RequestBody ProductDto productDto) {
        productService.save(productDto);
        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "添加成功");
    }

    @PutMapping("/{productId}")
    public Result update(@PathVariable("productId") UUID id, @RequestBody ProductDto productDto) {
        productDto.setId(id);
        productService.update(productDto);
        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "修改成功");
    }

    @DeleteMapping("/{productId}")
    public Result deleteById(@PathVariable("productId") UUID id) {
        productService.deleteById(id);
        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "删除成功");
    }

    @PostMapping("/search")
    public Result findSearch(@RequestBody ProductDto productDto) {
        List<ProductDto> list = productService.findSearch(productDto);
        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "查询成功", list);
    }

    @PostMapping("/search/{page}/{size}")
    public Result pageQuery(@RequestBody ProductDto productDto, @PathVariable("page") int currentPage, @PathVariable("size") int pageSize) {
        Page<ProductDto> pageData = productService.pageQuery(productDto, currentPage, pageSize);
        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "查询成功",
                new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
    }
}
