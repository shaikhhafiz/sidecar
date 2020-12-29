package com.hafiz.erp.sidecar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;

public class NodeJSHealthCheck implements SidecarHealthIndicator {

  @Value("${sidecar.port}")
  private int sidecarPort;

  @Override
  public Health health() {
    Health.Builder result = null;
    //TODO check node js health status in proper way and remove this hard coded string
    String output = "accepting connections";
    if (output.indexOf("accepting connections") != -1) {
      result = Health.up();
    } else if (output.indexOf("rejecting connections") != -1 || output.indexOf("no response") != -1) {
      result = Health.down().withDetail("reason", output);
    }
    return result.build();
  }
}
