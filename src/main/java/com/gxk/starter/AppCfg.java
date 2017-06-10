package com.gxk.starter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gxk.starter.hello.HelloCfg;
import com.gxk.starter.hello.HelloService;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;
import lombok.Data;

@Data
public class AppCfg extends Configuration {

  @Valid
  @NotNull
  @JsonProperty("hello")
  private HelloCfg helloCfg = new HelloCfg();
}