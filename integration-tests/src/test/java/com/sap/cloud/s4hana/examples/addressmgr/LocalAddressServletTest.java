package com.sap.cloud.s4hana.examples.addressmgr;

import com.sap.cloud.sdk.testutil.MockUtil;
import io.restassured.RestAssured;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

import static io.restassured.RestAssured.when;

@RunWith(Arquillian.class)
public class LocalAddressServletTest {

  private static final MockUtil mockUtil = new MockUtil();

  @ArquillianResource
  private URL baseUrl;

  @Deployment
  public static WebArchive createDepl() {
    return TestUtil.createDeployment(LocalAddressServlet.class);
  }

  @BeforeClass
  public static void beforeClass() {
    mockUtil.mockDefaults();
    mockUtil.mockErpDestination();
  }

  @Before
  public void before() {
    RestAssured.baseURI = baseUrl.toExternalForm();
  }

  @Test
  public void testGetAll() {
    when()
      .get("api/addresses-local")
      .then()
      .statusCode(500);
  }

  @Test
  public void testGetNew() {
    when()
      .get("api/addresses-local?status=NEW")
      .then()
      .statusCode(500);
  }

  @Test
  public void testGetApproved() {
    when()
      .get("api/addresses-local?status=UNKNOWN")
      .then()
      .statusCode(500);
  }

}
