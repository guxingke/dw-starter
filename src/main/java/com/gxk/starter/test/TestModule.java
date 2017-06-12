package com.gxk.starter.test;

import com.gxk.starter.AppCfg;
import com.gxk.starter.context.BaseBizModule;

import io.dropwizard.setup.Environment;

public class TestModule extends BaseBizModule {

  public TestModule(AppCfg cfg, Environment env) {
    super(cfg, env);
  }

  @Override
  protected void configure() {
    addHealthCheck("test", TestHealthCheck.class);
    addResource(TestResource.class);
  }
}
