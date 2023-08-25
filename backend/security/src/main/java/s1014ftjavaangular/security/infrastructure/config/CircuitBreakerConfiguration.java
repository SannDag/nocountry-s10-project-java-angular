package s1014ftjavaangular.security.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfiguration {
/*
    @Bean
    public CircuitBreaker userCircuitBreaker(){
        return CircuitBreaker.of("userCR", this.circuitBreakerConfig());
    }

    CircuitBreakerConfig circuitBreakerConfig(){
        return CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(4)
                .failureRateThreshold(50f)
                .permittedNumberOfCallsInHalfOpenState(2)
                .waitDurationInOpenState(Duration.ofSeconds(5))
                .writableStackTraceEnabled(false)
                .slowCallRateThreshold(40f)
                .slowCallDurationThreshold(Duration.ofSeconds(25))
                .build();
    }*/
}
