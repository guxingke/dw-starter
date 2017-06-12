package com.gxk.starter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.gxk.starter.context.BaseBizModule;
import com.gxk.starter.context.BaseModule;
import com.gxk.starter.context.RootModule;
import com.gxk.starter.hello.HelloModule;
import com.gxk.starter.test.TestModule;

import java.util.Arrays;
import java.util.List;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class App extends Application<AppCfg> {

  public static void main(String[] args) throws Exception {
    new App().run(args);
  }

  @Override
  public String getName() {
    return "dw-starter";
  }

  public void run(AppCfg cfg, Environment env) throws Exception {
    List<BaseModule> modules = Arrays.asList(
        new RootModule(cfg, env),
        
        new HelloModule(cfg, env),
        new TestModule(cfg, env)
    );

    Injector injector = Guice.createInjector(modules);

    for (BaseModule module : modules) {
      if (module instanceof BaseBizModule) {
        BaseBizModule bizModule = (BaseBizModule) module;
        bizModule.init(injector);
      }
    }
  }
}
