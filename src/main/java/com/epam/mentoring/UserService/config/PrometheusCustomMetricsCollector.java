package com.epam.mentoring.UserService.config;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.epam.mentoring.UserService.repository.UserRepository;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PrometheusCustomMetricsCollector {

    private final MeterRegistry meterRegistry;

    private final UserRepository userRepository;

    @PostConstruct
    public void setup() {
        Gauge.builder("jmp.order.counter", this::userCounter)
                .description("The number of user")
                .register(meterRegistry);
    }

    private Number userCounter() {
        return userRepository.count();
    }

}
