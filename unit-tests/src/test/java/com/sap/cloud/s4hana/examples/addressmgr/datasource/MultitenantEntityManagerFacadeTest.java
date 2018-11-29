package com.sap.cloud.s4hana.examples.addressmgr.datasource;

import org.junit.Test;

public class MultitenantEntityManagerFacadeTest {

  @Test
  public void getInstance() {
    try {
      MultitenantEntityManagerFacade.getInstance();
    } catch (Exception pE) {
      // This is only a dummy test
    }
  }
}
