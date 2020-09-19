package com.hafiz.erp.sidecar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  //TODO Check conditional on property for node js application using sidecar
//  @ConditionalOnProperty(name = "sidecar.postgres.enabled", havingValue = "true", matchIfMissing = false)
  @Bean
  public SidecarHealthIndicator postgresHealthCheck() {
    return new NodeJSHealthCheck();
  }

}
