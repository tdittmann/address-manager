package com.sap.cloud.s4hana.examples.addressmgr.datasource;

import org.junit.Test;

public class GenericEntityManagerFacadeTest {

  @Test
  public void getInstance() {
    try {
      GenericEntityManagerFacade.getInstance();
    } catch (Exception pE) {
      // This is only a dummy test
    }
  }
}
