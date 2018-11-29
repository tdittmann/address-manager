package com.sap.cloud.s4hana.examples.addressmgr.views;

import org.junit.Test;

public class AddressViewTest {

  @Test
  public void setId() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setId(123L);
  }

  @Test
  public void setBusinessPartner() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setBusinessPartner("123");
  }

  @Test
  public void setCityName() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setCityName("123");
  }

  @Test
  public void setCountry() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setCountry("123");
  }

  @Test
  public void setHouseNumber() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setHouseNumber("123");
  }

  @Test
  public void setPostalCode() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setPostalCode("123");
  }

  @Test
  public void setStreetName() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setStreetName("123");
  }

  @Test
  public void setStatus() {
    AddressView addressView = new AddressView(1L, "", "", "", "", "", "", "");
    addressView.setStatus("123");
  }
}
