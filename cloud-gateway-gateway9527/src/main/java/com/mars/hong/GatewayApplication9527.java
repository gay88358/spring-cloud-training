package com.mars.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.CookieRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.HeaderRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.ZonedDateTime;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication9527 {

    public static final String PAYMENT_SERVICE = "lb://CLOUD-PAYMENT-SERVICE";

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication9527.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/payments/lb")
                        .uri(PAYMENT_SERVICE)
//                        .predicate(new AfterRoutePredicateFactory().apply(afterRouteConfig()))
//                        .predicate(new CookieRoutePredicateFactory().apply(cookieRouteConfig()))
//                        .predicate(new HeaderRoutePredicateFactory().apply(headerRouteConfig()))
                        .id("payment_route"))
                .build();
    }
    // use curl to test header route filter
    // curl http://localhost:9527/payments/lb -H "X-Requed:1234"
    private HeaderRoutePredicateFactory.Config headerRouteConfig() {
        HeaderRoutePredicateFactory.Config result = new HeaderRoutePredicateFactory.Config();
        result.setHeader("X-Request-Id");
        result.setRegexp("1234");
        return result;
    }

    // use curl to test cookie route filter
    // curl http://localhost:9527/payments/lb --cookie "mars=hong"
    private CookieRoutePredicateFactory.Config cookieRouteConfig() {
        CookieRoutePredicateFactory.Config result = new CookieRoutePredicateFactory.Config();
        result.setName("mars");
        result.setRegexp("hong");
        return result;
    }

    private AfterRoutePredicateFactory.Config afterRouteConfig() {
        AfterRoutePredicateFactory.Config result = new AfterRoutePredicateFactory.Config();
        result.setDatetime(ZonedDateTime.now().plusMinutes(1));
        return result;
    }
}
