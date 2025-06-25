package dev.chhaya.customer.client;

import dev.chhaya.customer.client.dto.CategoryResponse;
import dev.chhaya.customer.client.dto.CreateProductRequest;
import dev.chhaya.customer.client.dto.ProductResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface PlatziFakeStoreClient {

    @PostExchange("/products")
    ProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest);

    @GetExchange("/products")
    List<ProductResponse> getProducts(@RequestParam Integer offset,
                                      @RequestParam Integer limit);

    @GetExchange("/products/{id}")
    ProductResponse getProductById(@PathVariable Integer id);

    @GetExchange("/categories")
    List<CategoryResponse> getCategories();

}
