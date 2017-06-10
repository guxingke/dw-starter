package com.gxk.starter.hello;

import javax.inject.Inject;

/**
 * @author gxk
 * @since 2017/6/10 обнГ4:38
 */
public class HelloService {

  private HelloCfg helloCfg;

  @Inject
  public HelloService(HelloCfg helloCfg) {
    this.helloCfg = helloCfg;
  }

  public String getTemplate() {
    return this.helloCfg.getTemplate();
  }

  public String getName() {
    return this.helloCfg.getDefaultName();
  }
}
