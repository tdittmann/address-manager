package com.sap.cloud.s4hana.examples.addressmgr.datasource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.cloud.service.common.PostgresqlServiceInfo;

import java.util.Map;

public class MultitenantEntityManagerFacadeTest {

  @Test
  public void buildProperties() {
    PostgresqlServiceInfo serviceInfo = new PostgresqlServiceInfo("service-id", "test-url");

    Map<String, String> stringStringMap = MultitenantEntityManagerFacade.getInstance().buildProperties(serviceInfo);

    Assert.assertEquals(1, stringStringMap.size());
  }

  @Test
  public void getInstance() {
    MultitenantEntityManagerFacade instance = MultitenantEntityManagerFacade.getInstance();
    Assert.assertNotNull(instance);
  }
}
