package com.challenge.hulkstore.controllers;

import com.challenge.hulkstore.models.ProductToSell;
import com.challenge.hulkstore.services.CartService;
import com.challenge.hulkstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/v1")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    private final List<ProductToSell> productToSellList = new ArrayList<>();

    @GetMapping(value = "/cart")
    public List<ProductToSell> getCart() {
        return productToSellList;
    }

    @PostMapping(value = "/cart/{id}")
    public ResponseEntity<List<ProductToSell>> addProductToCart(@PathVariable long id) {
        List<ProductToSell> cartProducts = getCart();

        return ResponseEntity.ok(cartService.addProductToCart(cartProducts, id));
    }

    @DeleteMapping(value = "/cart/{id}")
    public ResponseEntity<ProductToSell> deleteFromCart(@PathVariable long id) {
        List<ProductToSell> cart = getCart();
        cartService.deleteProductToSell(cart, id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/cart")
    public ResponseEntity<ProductToSell> cleanCart() {
        productToSellList.clear();
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/cart")
    public ResponseEntity<ProductToSell> endSellCart() {
        List<ProductToSell> cart = getCart();
        cartService.endSellCart(cart);
        productToSellList.clear();

        return ResponseEntity.noContent().build();
    }
}
