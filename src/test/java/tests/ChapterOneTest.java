package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ChapterOneTest extends BaseTest {
    @Test
    //@DataProvider("")
    public void requestUSZipCodeBH() {
        given().
                log().all().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                log().body().
                assertThat().
                /********* Here we are using json path statement to extract the first element of the place name which API returns  **********/
                        body("places[0].'place name'", equalTo("Beverly Hills")).
                statusCode(200).
                contentType("application/json");
    }
}
