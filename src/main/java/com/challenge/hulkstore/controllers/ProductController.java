package com.challenge.hulkstore.controllers;

import com.challenge.hulkstore.models.Product;
import com.challenge.hulkstore.models.User;
import com.challenge.hulkstore.services.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Api(description = "Endpoints for Creating, Retrieving, Updating and Deleting of Products")
@RestController
@RequestMapping("/app/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @ApiOperation(value = "Get a product by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@ApiParam(value = "Product Id", required = true, type = "long") @PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/product/{id}")
    public Product editProductById(@RequestBody Product product, @PathVariable Long id) {
        return productService.editProduct(product, id);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.newProduct(product));
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}
