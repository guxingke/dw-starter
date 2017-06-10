package com.gxk.starter.test;

import com.codahale.metrics.annotation.Timed;
import com.gxk.starter.context.Resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author gxk
 * @since 2017/6/10 обнГ6:11
 */
@Path("test")
@Produces(MediaType.APPLICATION_JSON)
@Resource
public class TestResource {

  @GET
  @Timed
  public String now() {
    return new Date().toString();
  }
}
