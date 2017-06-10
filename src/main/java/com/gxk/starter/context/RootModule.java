package com.gxk.starter.context;

import com.gxk.starter.AppCfg;

import io.dropwizard.setup.Environment;

/**
 * @author gxk
 * @since 2017/6/10 ионГ11:37
 */
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
