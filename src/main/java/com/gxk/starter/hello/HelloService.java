package com.gxk.starter.hello;

import javax.inject.Inject;

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
