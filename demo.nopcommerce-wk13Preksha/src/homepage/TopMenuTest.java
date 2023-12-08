package homepage;

import browsertesting.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


   @Test
    public void testthisout(){
       selectMenu("//div[@class='header-menu']/ul[1]/li[1]/a");
       verifyPageNavigation("//div[@class='page-title']/h1", "Computers");
    }


}
