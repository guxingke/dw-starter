package com.gxk.starter.context;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Injector;
import com.gxk.starter.AppCfg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.dropwizard.setup.Environment;

/**
 * @author gxk
 * @since 2017/6/10 ÏÂÎç5:31
 */
public abstract class BaseBizModule extends BaseModule {

  private Map<String, Class<? extends HealthCheck>> healthChecks = new LinkedHashMap<>(2);
  private List<Class> resources = new ArrayList<>(2);

  public BaseBizModule(AppCfg cfg, Environment env) {
    super(cfg, env);
  }

  @Override
  protected abstract void configure();

  public void init(Injector injector) {
    initHealthChecks(injector);
    initResources(injector);
  }

  protected void initResources(Injector injector) {
    if (this.resources.isEmpty()) {
      return;
    }

    resources.forEach(clazz->{
      env.jersey().register(injector.getInstance(clazz));
    });
  }

  protected void initHealthChecks(Injector injector) {
    if (this.healthChecks.isEmpty()) {
      return;
    }

    healthChecks.forEach((key, value) -> {
      env.healthChecks().register(key, injector.getInstance(value));
    });
  }

  protected void addHealthCheck(String name, Class<? extends HealthCheck> clazz) {
    this.healthChecks.put(name, clazz);
  }

  protected void addResource(Class resource) throws IllegalArgumentException {
    if (!resource.isAnnotationPresent(Resource.class)) {
      throw new IllegalArgumentException("resources should be has @Resource");
    }

    this.resources.add(resource);
  }
}
