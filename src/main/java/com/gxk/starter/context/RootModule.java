package com.gxk.starter.context;

import com.gxk.starter.AppCfg;

import io.dropwizard.setup.Environment;

public class RootModule extends BaseModule {

  public RootModule(AppCfg cfg, Environment env) {
    super(cfg, env);
  }

  @Override
  protected void configure() {
    bind(AppCfg.class).toInstance(cfg);
    bind(Environment.class).toInstance(env);
  }
}
