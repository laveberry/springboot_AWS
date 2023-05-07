package com.laveberry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //JPA Auditing활성화 메인에서 분리
public class JpaConfig {
}
