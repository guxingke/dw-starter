package com.gxk.starter.context;

import com.google.inject.AbstractModule;
import com.gxk.starter.AppCfg;

 import io.dropwizard.setup.Environment;

/**
 * @author gxk
 * @since 2017/6/9 обнГ11:09
 */
public abstract class BaseModule extends AbstractModule {
  protected final AppCfg cfg;
  protected final Environment env;

  protected BaseModule(AppCfg cfg, Environment env) {
    this.cfg = cfg;
    this.env = env;
  }

}
