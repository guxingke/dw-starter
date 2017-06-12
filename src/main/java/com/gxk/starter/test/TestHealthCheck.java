package com.gxk.starter.test;

import com.codahale.metrics.health.HealthCheck;

import java.util.Random;

public class TestHealthCheck extends HealthCheck {

  @Override
  protected Result check() throws Exception {
    int nextInt = new Random().nextInt(10);

    if (nextInt > 5) {
      return Result.unhealthy("random result gt 5");
    }

    return Result.healthy("result lte 5");
  }

}
