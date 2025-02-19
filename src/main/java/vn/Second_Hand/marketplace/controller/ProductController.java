package vn.Second_Hand.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.Second_Hand.marketplace.dto.Response;
import vn.Second_Hand.marketplace.entity.Category;
import vn.Second_Hand.marketplace.entity.Product;
import vn.Second_Hand.marketplace.service.ICategoryService;
import vn.Second_Hand.marketplace.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/marketplace")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<Response<Category>>(new Response(true, "Các danh mục hiện có", categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("/products/category/{maDanhMuc}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable int maDanhMuc) {
        List<Product> products = productService.getProductsByCategory(maDanhMuc);
        if (products.isEmpty()) {
            return new ResponseEntity<Response<Product>>(new Response(true, "Không có sản phẩm nào", null), HttpStatus.OK);
        }
        return new ResponseEntity<Response<Product>>(new Response(true, "Danh sách sản phẩm theo danh mục", productService.getProductsByCategory(maDanhMuc)), HttpStatus.OK);
    }

    @GetMapping("/products/top-10")
    public ResponseEntity<?> getTop10BestSellingProducts() {
        return new ResponseEntity<Response<Product>>(new Response(true, "Top 10 sản phẩm bán chạy nhất", productService.getTop10BestSellingProducts()), HttpStatus.OK);
    }

    @GetMapping("/products/last-7-days")
    public ResponseEntity<?> getProductsCreatedLast7Days() {
        return new ResponseEntity<Response<Product>>(new Response(true, "Top 10 sản phẩm được tạo <=7 ngày", productService.getProductsCreatedLast7Days()), HttpStatus.OK);
    }

}
