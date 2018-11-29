package com.sap.cloud.s4hana.examples.addressmgr.commands;

import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartnerAddress;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import com.sap.cloud.sdk.testutil.MockUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GetSingleBusinessPartnerByIdCommandTest {

  private MockUtil mockUtil;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private BusinessPartnerService service;

  @Before
  public void before() {
    mockUtil = new MockUtil();
    mockUtil.mockDefaults();
    mockUtil.mockDestination("ErpQueryEndpoint", URI.create(""));
  }

  @Test
  public void testGetAll() throws ODataException {
    BusinessPartner alice = new BusinessPartner();
    alice.setFirstName("Alice");
    alice.setLastName("Miller");

    when(service
      .getBusinessPartnerByKey(any())
      .select(BusinessPartner.BUSINESS_PARTNER,
        BusinessPartner.LAST_NAME,
        BusinessPartner.FIRST_NAME,
        BusinessPartner.IS_MALE,
        BusinessPartner.IS_FEMALE,
        BusinessPartner.CREATION_DATE,
        BusinessPartner.TO_BUSINESS_PARTNER_ADDRESS.select(
          BusinessPartnerAddress.BUSINESS_PARTNER,
          BusinessPartnerAddress.ADDRESS_ID,
          BusinessPartnerAddress.COUNTRY,
          BusinessPartnerAddress.POSTAL_CODE,
          BusinessPartnerAddress.CITY_NAME,
          BusinessPartnerAddress.STREET_NAME,
          BusinessPartnerAddress.HOUSE_NUMBER))
      .execute()
    ).thenReturn(alice);

    BusinessPartner result = new GetSingleBusinessPartnerByIdCommand(service, "id").execute();

    Assert.assertEquals("Alice", result.getFirstName());
    Assert.assertEquals("MILLER", result.getLastName());
  }

}
