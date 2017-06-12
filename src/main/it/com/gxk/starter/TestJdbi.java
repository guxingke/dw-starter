package com.gxk.starter;

import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.StringMapper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author gxk
 * @since 2017/6/12 下午9:26
 */
public class TestJdbi {

  @org.junit.Test
  public void test() {
    JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:test", "username", "password");

    DBI dbi = new DBI(ds);
    Handle h = dbi.open();
    h.execute("create table something (id int primary key, name varchar(100))");

    h.execute("insert into something (id, name) values (?, ?)", 1, "Brian");

    String name = h.createQuery("select name from something where id = :id")
        .bind("id", 1)
        .map(StringMapper.FIRST)
        .first();

    assertThat(name, equalTo("Brian"));
    h.close();
  }

}