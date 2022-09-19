package com.charuniverse.invoice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // TODO: Implement auditor using spring security
        // if using spring security
        // SecurityContextHolder.getContext().getAuthentication().getName();
        return () -> Optional.ofNullable("Akbar Ganteng");
    }

}
