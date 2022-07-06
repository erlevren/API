import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrls {
    public RequestSpecification spec;

    // @Before annotation'i kullandigimiz methodlar her test methodundan once calisir
    @Before
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/todos/23").build();
    }
}
