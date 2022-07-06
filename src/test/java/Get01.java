import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;// Given, when, then, and' hepsini birden import icin '*' kullanilir

public class Get01 {

    /*
    1) Postman manuel API testi icin kullanilir.
    2) API otomasyon testi icin Rest-Assured Library kullaniyoruz.
    3) Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
        a) Gereksinimleri anlama
        b) Test Case'i yazma
            i) Test case yazimi icin 'Gherkin Language' kullaniyoruz
                'Gherkin' bazi keywordlere sahip, bunlar:
                    - Given: On kosullar
                    - When: Aksiyonlar -->Get, Put, ...
                    - Then: Ciktilar, Donutler--> dogrulama, response
                    - And: Coklu islemler icin kullanilir
        c) Testing kodunun yazimi
            i) Set the URL
            ii) Set the expected data(POST-PUT-PATCH)
            iii) Type code to send request
            iv) Do Assertion
     */
    /*
        Given
            https://restful-booker.herokuapp.com/booking/3 // End pointimiz elimizde
        When
            User sends a GET Request to the url //
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01() {
        //   i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/1262";
        //   ii) Set the expected data(POST-PUT-PATCH)

        //   iii) Type code to send request
        Response response = given().when().get(url);
        response.prettyPrint();
        System.out.println("=============================");
        //   iv) Do Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");
        System.out.println("Status Line : "+response.statusLine());
        System.out.println("Content type : "+response.contentType());
        System.out.println("Status Code : "+response.getStatusCode());

        // 'Header' nasil yazdirilir
        System.out.println(response.header("Connection"));
        System.out.println("Headers : \n"+response.headers());
        System.out.println("Time : "+response.getTime());


    }
}
