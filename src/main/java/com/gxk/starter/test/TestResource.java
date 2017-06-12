package com.gxk.starter.test;

import com.codahale.metrics.annotation.Timed;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

  @GET
  @Timed
  public String now() {
    return new Date().toString();
  }
}
