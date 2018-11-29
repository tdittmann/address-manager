package com.sap.cloud.s4hana.examples.addressmgr.models;

import org.junit.Assert;
import org.junit.Test;

public class StatusTest {

  @Test
  public void testStatus() {
    Assert.assertEquals(Status.APPROVED, Status.valueOf("APPROVED"));
    Assert.assertEquals(Status.NEW, Status.valueOf("NEW"));
    Assert.assertEquals(Status.REJECTED, Status.valueOf("REJECTED"));
  }

}
