package com.sap.cloud.s4hana.examples.addressmgr.views;

import com.sap.cloud.s4hana.examples.addressmgr.models.Address;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ViewModelConverterTest {

  @Test
  public void convertAddressToAddressView() {
    Address address = new Address(1L, "businessPartner", "München", "Germany", "12", "778866", "Street", "ok");

    AddressView addressView = ViewModelConverter.convertAddressToAddressView(address);

    Assert.assertEquals(new Long(1L), addressView.getId());
    Assert.assertEquals("businessPartner", addressView.getBusinessPartner());
    Assert.assertEquals("München", addressView.getCityName());
    Assert.assertEquals("Germany", addressView.getCountry());
    Assert.assertEquals("12", addressView.getHouseNumber());
    Assert.assertEquals("778866", addressView.getPostalCode());
    Assert.assertEquals("Street", addressView.getStreetName());
    Assert.assertEquals("ok", addressView.getStatus());
  }

  @Test
  public void convertAddressesToAddressViews() {
    Address address = new Address(1L, "businessPartner", "München", "Germany", "12", "778866", "Street", "ok");

    List<AddressView> addressView = ViewModelConverter.convertAddressesToAddressViews(Arrays.asList(address));

    Assert.assertEquals(1, addressView.size());
    Assert.assertEquals(new Long(1L), addressView.get(0).getId());
    Assert.assertEquals("businessPartner", addressView.get(0).getBusinessPartner());
    Assert.assertEquals("München", addressView.get(0).getCityName());
    Assert.assertEquals("Germany", addressView.get(0).getCountry());
    Assert.assertEquals("12", addressView.get(0).getHouseNumber());
    Assert.assertEquals("778866", addressView.get(0).getPostalCode());
    Assert.assertEquals("Street", addressView.get(0).getStreetName());
    Assert.assertEquals("ok", addressView.get(0).getStatus());
  }

  @Test
  public void convertAddressViewToAddress() {
    AddressView addressView = new AddressView(1L, "businessPartner", "München", "Germany", "12", "778866", "Street", "ok");

    Address address = ViewModelConverter.convertAddressViewToAddress(addressView);

    Assert.assertEquals(new Long(1L), address.getId());
    Assert.assertEquals("businessPartner", address.getBusinessPartner());
    Assert.assertEquals("München", address.getCityName());
    Assert.assertEquals("Germany", address.getCountry());
    Assert.assertEquals("12", address.getHouseNumber());
    Assert.assertEquals("778866", address.getPostalCode());
    Assert.assertEquals("Street", address.getStreetName());
    Assert.assertEquals("ok", address.getStatus());
  }
}
