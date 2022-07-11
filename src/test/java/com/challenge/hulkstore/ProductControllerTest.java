package com.challenge.hulkstore;

import com.challenge.hulkstore.controllers.ProductController;
import com.challenge.hulkstore.errors.ProductNotFoundException;
import com.challenge.hulkstore.models.Product;
import com.challenge.hulkstore.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @Test
    void shouldCreateProduct() {
        Product product = new Product(1L, "Remera", 100, 10, 1, 1);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(productService.newProduct(any(Product.class))).thenReturn(product);
        ResponseEntity<Product> responseEntity = productController.newProduct(product);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody()).isEqualTo(product);
    }

    @Test
    void shouldFindProduct() {
        Product product = new Product(1L, "Remera", 100, 10, 1, 1);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(productService.getProductById(1L)).thenReturn(Optional.of(product));
        ResponseEntity<Optional<Product>> response = productController.getProductById(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().get().getId()).isEqualTo(1L);
        assertThat(response.getBody().get().getDescription()).isEqualTo("Remera");
        assertThat(response.getBody().get().getPrice()).isEqualTo(100);
        assertThat(response.getBody().get().getStock()).isEqualTo(10);
        assertThat(response.getBody().get().getFranchiseId()).isEqualTo(1);
        assertThat(response.getBody().get().getUserId()).isEqualTo(1);
    }

    @Test
    void shouldFailToFindProduct() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(productService.getProductById(100L)).thenThrow(new ProductNotFoundException(100L));
        try {
            ResponseEntity<Optional<Product>> response = productController.getProductById(100L);
        } catch (final ProductNotFoundException e) {
            final String errorMessage = "Unable to find Product ID: 100";
            assertThat(errorMessage).isEqualTo(e.getMessage());
        }
    }
}
