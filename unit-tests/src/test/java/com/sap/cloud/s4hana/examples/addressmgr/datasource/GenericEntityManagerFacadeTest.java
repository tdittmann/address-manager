package com.sap.cloud.s4hana.examples.addressmgr.datasource;

import org.junit.Assert;
import org.junit.Test;

public class GenericEntityManagerFacadeTest {

  @Test
  public void getInstance() {
    GenericEntityManagerFacade instance = GenericEntityManagerFacade.getInstance();
    Assert.assertNotNull(instance);
  }
}
