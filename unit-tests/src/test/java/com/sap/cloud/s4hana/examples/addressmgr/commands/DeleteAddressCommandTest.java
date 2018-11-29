package com.sap.cloud.s4hana.examples.addressmgr.commands;

import com.sap.cloud.sdk.odatav2.connectivity.ODataDeleteResult;
import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartnerAddress;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import com.sap.cloud.sdk.testutil.MockUtil;
import org.apache.http.ProtocolVersion;
import org.apache.http.message.BasicHttpResponse;
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
public class DeleteAddressCommandTest {

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
  public void testCreateAddress() throws ODataException {
    BusinessPartnerAddress munich = new BusinessPartnerAddress();
    munich.setCountry("Germany");
    munich.setCityCode("778899");
    munich.setCityName("Munich");

    when(service
      .deleteBusinessPartnerAddress(any(BusinessPartnerAddress.class))
      .execute()
    ).thenReturn(new ODataDeleteResult(new BasicHttpResponse(new ProtocolVersion("http", 1, 1), 200, "ok")));

    Integer result = new DeleteAddressCommand(service, "pbId", "addressId").execute();

    Assert.assertEquals(new Integer(1), result);
  }

}
