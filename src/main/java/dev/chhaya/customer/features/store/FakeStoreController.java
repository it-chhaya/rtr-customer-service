package dev.chhaya.customer.features.store;

import dev.chhaya.customer.client.PlatziFakeStoreClient;
import dev.chhaya.customer.client.dto.CategoryResponse;
import dev.chhaya.customer.client.dto.CreateProductRequest;
import dev.chhaya.customer.client.dto.FileUploadResponse;
import dev.chhaya.customer.client.dto.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class FakeStoreController {

    private final PlatziFakeStoreClient platziFakeStoreClient;

    @PostMapping("/files/upload")
    public FileUploadResponse uploadFile(@RequestPart MultipartFile file) {
        return platziFakeStoreClient.uploadFile(file);
    }


    @PostMapping("/products")
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return platziFakeStoreClient.createProduct(createProductRequest);
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts(
            @RequestParam(required = false, defaultValue = "0") Integer offset,
            @RequestParam(required = false, defaultValue = "5") Integer limit
    ) {
        return platziFakeStoreClient.getProducts(offset, limit);
    }


    @GetMapping("/products/{id}")
    ResponseEntity<?> getProductById(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .ok(platziFakeStoreClient.getProductById(id)
                    );
        } catch (WebClientResponseException e) {
            return new ResponseEntity<>(Map.of(
                    "error", e.getMessage()
            ), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categories")
    public List<CategoryResponse> getCategories() {
        return platziFakeStoreClient.getCategories();
    }

}
