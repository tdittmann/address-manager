package com.sap.cloud.s4hana.examples.addressmgr.models;

import org.junit.Test;

public class AddressTest {

  @Test
  public void testSetter() {
    Address address = new Address();

    address.setBusinessPartner("123");
    address.setCityName("123");
    address.setCountry("123");
    address.setHouseNumber("123");
    address.setPostalCode("123");
    address.setStatus("123");
    address.setStreetName("123");
    address.hashCode();

    address.canEqual(null);
    address.canEqual(new Address());
    address.equals(null);
    address.equals(new Address());
  }

}
