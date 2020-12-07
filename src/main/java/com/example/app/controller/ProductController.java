package com.example.app.controller;

import com.example.app.model.Product;
import com.example.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(Model model) {
        return productService.getAllProducts();
    }

    @GetMapping("/products/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String productId) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") String productId) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(productId);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public Product insertNewProduct(@RequestBody() Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products/put/{id}")
    public void setProductPrizeToZero(@PathVariable("id") String productId) {
        productService.putProductPrizeToZero(productId);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }
}
