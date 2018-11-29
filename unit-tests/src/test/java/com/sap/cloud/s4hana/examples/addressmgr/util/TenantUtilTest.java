package com.sap.cloud.s4hana.examples.addressmgr.util;

import org.junit.Assert;
import org.junit.Test;

public class TenantUtilTest {

  @Test
  public void createSchemaName() {
    String tenant = TenantUtil.createSchemaName("public");
    Assert.assertEquals("public", tenant);

    tenant = TenantUtil.createSchemaName("asdasdasd");
    Assert.assertEquals("TENANT_asdasdasd", tenant);
  }
}
