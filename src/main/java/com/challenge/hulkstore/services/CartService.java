package com.challenge.hulkstore.services;

import com.challenge.hulkstore.errors.ProductNotFoundException;
import com.challenge.hulkstore.errors.ProductOutOfStockException;
import com.challenge.hulkstore.models.Product;
import com.challenge.hulkstore.models.ProductToSell;
import com.challenge.hulkstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    public List<ProductToSell> addProductToCart(List<ProductToSell> cartProducts, long id) {
        Product productToSell = productService.getProductById(id).orElseThrow(() -> new ProductNotFoundException(id));
        if (productToSell.getStock() == 0) {
            throw new ProductOutOfStockException(id);
        }

        boolean productFound = false;
        for (ProductToSell currentProductForSale : cartProducts) {
            if (currentProductForSale.getId() == productToSell.getId()) {
                currentProductForSale.increaseQuantity();
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            cartProducts
                    .add(new ProductToSell(productToSell.getId(), productToSell.getDescription(), productToSell.getPrice(), productToSell.getStock(), productToSell.getFranchiseId(), productToSell.getUserId(), 1));
        }

        return cartProducts;
    }

    public void deleteProductToSell(List<ProductToSell> cart, long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        if (cart.stream().anyMatch(p -> p.getId() == id)) {
            int indexOfElement = IntStream.range(0, cart.size()).
                    filter(i -> id == cart.get(i).getId()).
                    findFirst().orElse(-1);
            cart.remove(indexOfElement);
        } else throw new ProductNotFoundException(id);
    }

    public void endSellCart(List<ProductToSell> cart) {
        for (ProductToSell productToSell : cart) {
            Product product = productService.getProductById(productToSell.getId()).orElse(null);
            if (product == null) continue;
            product.reduceStock(productToSell.getQuantity());
            productService.editProduct(productToSell, product.getId());
        }
    }
}
