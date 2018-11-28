package com.sap.cloud.s4hana.examples.addressmgr.commands;

import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.Order;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartnerSelectable;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import com.sap.cloud.sdk.testutil.MockUtil;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URI;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GetAllBusinessPartnersCommandTest {

  private MockUtil mockUtil;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private BusinessPartnerService service;

  @Before
  public void before() {
    mockUtil = new MockUtil();
    mockUtil.mockDefaults();
    mockUtil.mockDestination("ErpQueryEndpoint", URI.create(""));

    new GetAllBusinessPartnersCommand(null).getCache().invalidateAll();
  }

  @Test
  public void testGetAll() throws ODataException {
    BusinessPartner alice = new BusinessPartner();
    alice.setFirstName("Alice");
    alice.setLastName("Miller");

    when(service.getAllBusinessPartner()
      .select(any(BusinessPartnerSelectable.class))
      .filter(BusinessPartner.BUSINESS_PARTNER_CATEGORY.eq("1"))
      .orderBy(BusinessPartner.LAST_NAME, Order.ASC)
      .execute()
    ).thenReturn(Lists.newArrayList(alice));

    List<BusinessPartner> result = new GetAllBusinessPartnersCommand(service).execute();

    Assert.assertEquals(1, result.size());
    Assert.assertEquals("Alice", result.get(0).getFirstName());
    Assert.assertEquals("MILLER", result.get(0).getLastName());
  }
}
