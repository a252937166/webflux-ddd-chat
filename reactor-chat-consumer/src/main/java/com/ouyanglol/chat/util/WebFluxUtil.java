package com.ouyanglol.chat.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:40
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WebFluxUtil<T> {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${provider.url}")
    private String serviceUrl;

    public Mono<T> mono(HttpMethod method, String url, Class<T> clazz, Object body) {
        WebClient.RequestBodySpec spec = webClientBuilder.build()
                .method(method)
                .uri(serviceUrl + url);
        if (body != null) {
            spec.bodyValue(body);
        }
        return spec.retrieve().bodyToMono(clazz);
    }

    public Flux<T> flux(HttpMethod method, String url, Class<T> clazz, Object body) {
        WebClient.RequestBodySpec spec = webClientBuilder.build()
                .method(method)
                .uri(serviceUrl + url);
        if (body != null) {
            spec.bodyValue(body);
        }
        return spec.retrieve().bodyToFlux(clazz);
    }
}
