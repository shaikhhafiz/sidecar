package com.hafiz.erp.sidecar.controller;

import com.hafiz.erp.sidecar.config.SidecarHealthIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthStatusDelegatorController {

  @Autowired
  private SidecarHealthIndicator healthIndicator;

  @RequestMapping("/health-status")
  public Health sidecarHealthStatus() {
    return this.healthIndicator.health();
  }

}
