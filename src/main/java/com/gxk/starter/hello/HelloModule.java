package com.gxk.starter.hello;

import com.gxk.starter.AppCfg;
import com.gxk.starter.context.BaseBizModule;

import io.dropwizard.setup.Environment;

/**
 * @author gxk
 * @since 2017/6/10 ÉÏÎç11:36
 */
public class HelloModule extends BaseBizModule {

  public HelloModule(AppCfg cfg, Environment env) {
    super(cfg, env);
  }

  @Override
  protected void configure() {
    bind(HelloService.class).toInstance(new HelloService(cfg.getHelloCfg()));
    bind(TemplateHealthCheck.class).toInstance(new TemplateHealthCheck(cfg.getHelloCfg().getTemplate()));

    addHealthCheck("template", TemplateHealthCheck.class);
    addResource(HelloWorldResource.class);
  }
}
