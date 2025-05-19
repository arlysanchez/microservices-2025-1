package upeu.edu.pe.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Set;

@Configuration
public class GatewayBeans {
    //config routes level basic
    @Bean
    @Profile(value = "eureka-off")
    public RouteLocator routeLocatorEurekaOff (RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(route -> route
                        .path("/companies-crud/company/*")
                        .uri("http://localhost:8081")
                )
                .route(route -> route
                        .path("/report-ms/report/*")
                        .uri("http://localhost:7070")
                )
                .build();
    }
    @Bean
    @Profile(value = "eureka-on")
    public RouteLocator routeLocatorEurekaOn (RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(route -> route
                        .path("/companies-crud/company/**")
                        .uri("lb://companies-crud")  //load balance = lb = balanceo de carga
                )
                .route(route -> route
                        .path("/report-ms/report/**")
                        .uri("lb://report-ms")
                )
                .build();
    }




}
