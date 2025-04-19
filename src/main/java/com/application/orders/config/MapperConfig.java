package com.application.orders.config;

import com.application.orders.mappers.OrderMapper;
import com.application.orders.mappers.OrderSimplifiedMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public OrderSimplifiedMapper orderSimplifiedMapper() {
        return OrderSimplifiedMapper.INSTANCE;
    }

    @Bean
    public OrderMapper orderMapper() { return OrderMapper.INSTANCE; }
}
