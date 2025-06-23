package dev.chhaya.customer.client;

import dev.chhaya.customer.client.dto.PostResponse;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface JsonPlaceholderClient {

    @GetExchange("/posts")
    List<PostResponse> getPosts();

}
