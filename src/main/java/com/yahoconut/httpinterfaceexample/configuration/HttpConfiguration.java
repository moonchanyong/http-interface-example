package com.yahoconut.httpinterfaceexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpConfiguration {
    @Bean
    public WebClient client() {
        return WebClient.builder().baseUrl("http://localhost:8080").build();
    }
// if you want to use general way, uncomment below code and remove `HttpExchangePostProcessor`.
//    @Bean
//    public HttpServiceProxyFactory httpServiceProxyFactory(WebClient client) {
//        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
//    }
//
//    @Bean
//    public ProductService productService(HttpServiceProxyFactory httpServiceProxyFactory) {
//        return httpServiceProxyFactory.createClient(ProductService.class);
//    }
//
//    @Bean
//    public PaymentService paymentService(HttpServiceProxyFactory httpServiceProxyFactory) {
//        return httpServiceProxyFactory.createClient(PaymentService.class);
//    }

//    @Bean
//    public HttpExchangeInterface interfaces(WebClient client) {
//        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
//        Class<? extends HttpExchangeInterface>[] interfaces = (Class<? extends HttpExchangeInterface>[]) ClassUtils.getAllInterfaces(HttpExchangeInterface.class);
//        System.out.println(interfaces);
//        return null;
////        return new ArrayList<>();
//    }
}
