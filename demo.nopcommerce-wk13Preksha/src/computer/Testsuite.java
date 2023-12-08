package computer;

import browsertesting.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Testsuite extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    public void selectMenu(String menu) {
        WebElement selectMenu = driver.findElement(By.xpath(menu));
        selectMenu.click();
    }

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void testname(){
        selectMenu("//div[@class='header-menu']/ul[1]/li[1]/a");
        selectMenu("//div[@class='item-grid']/div[1]/div/h2/a");
        WebElement sortByPosition = driver.findElement (By.name("products-orderby"));
        sortByPosition.click();
        Select select =new Select(sortByPosition);
        select.selectByIndex(2);
        verifyPageNavigation("//div[@class='page-title']/h1","Desktops");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        selectMenu("//div[@class='header-menu']/ul[1]/li[1]/a");
        selectMenu("//div[@class='item-grid']/div[1]/div/h2/a");
        WebElement sortByPosition = driver.findElement (By.name("products-orderby"));
        sortByPosition.click();
        Select select =new Select(sortByPosition);
        select.selectByIndex(1);
        Thread.sleep(1000);
        selectMenu("//div[@class='product-grid']/div/div[1]/div/div[2]/div[3]/div[2]/button[1]");
        verifyPageNavigation("//div[@class='product-name']/h1","Build your own computer");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement sortbyghz = driver.findElement(By.id("product_attribute_1"));
        sortbyghz.click();
        Select s2 = new Select(sortbyghz);
        s2.selectByIndex(1);
        //2.7.Select "8GB [+$60.00]" using Select class.
        WebElement sortbyram = driver.findElement(By.id("product_attribute_2"));
        sortbyram.click();
        Select s3 = new Select(sortbyram);
        s3.selectByIndex(3);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.id("product_attribute_3_7")).click();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.id("product_attribute_4_9")).click();
        //A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        driver.findElement(By.id("product_attribute_5_12")).click();
        Thread.sleep(1000);
        //2.11 Verify the price "$1,475.00"
        verifyPageNavigation("//div[@class='product-price']/span","$1,475.00");
        //2.12 Click on "ADD TO CARD" Button.
        driver.findElement(By.id("add-to-cart-button-1")).click();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top
        verifyPageNavigation("//div[@class='bar-notification success']/p","The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='bar-notification']/div/span")).click();
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(650,100)","");
        Actions actions = new Actions(driver);
        WebElement shoppingcart = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]/a/span[1]"));
        WebElement shopclick = driver.findElement(By.xpath("//div[@id='flyout-cart']/div/div[4]/button"));
        actions.moveToElement(shopclick).click().build().perform();
        //driver.findElement(By.xpath("//div[@id='flyout-cart']/div/div[4]/button")).click();

         */
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]/a/span[1]")).click();
        //2.15 Verify the message "Shopping cart"
        verifyPageNavigation("//div[@class='page-title']/h1","Shopping cart");
       //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//div[@class='table-wrapper']/table/tbody/tr/td[5]/input")).clear();
        driver.findElement(By.xpath("//div[@class='table-wrapper']/table/tbody/tr/td[5]/input")).sendKeys("2");
        driver.findElement(By.id("updatecart")).click();
        //2.17 Verify the Total"$2,950.00"
        verifyPageNavigation("//div[@class='total-info']/table/tbody/tr[4]/td[2]/span/strong","$2,950.00");
        //2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.id("termsofservice")).click();
        //2.19 Click on “CHECKOUT”
        driver.findElement(By.id("checkout")).click();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyPageNavigation("//div[@class='page-title']/h1","Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        selectMenu("//div[@class='customer-blocks']/div[1]/div[3]/button[1]");
        //2.22 Fill the all mandatory field
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Tom");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Smith");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("tomsmith88@aol.com");
        WebElement ddcountry = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select selectcountry = new Select(ddcountry);
        selectcountry.selectByIndex(1);
        Thread.sleep(1000);
        WebElement state = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select selectstate =new Select(state);
        selectstate.selectByIndex(53);
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Dallas");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("1 main st");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("1234");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("999-000-9090");
        selectMenu("//div[@id='billing-buttons-container']/button[4]");
        driver.findElement(By.id("shippingoption_1")).click();
        selectMenu("//div[@id='shipping-method-buttons-container']/button");
        driver.findElement(By.id("paymentmethod_1")).click();
        driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/button")).click();


        WebElement pickMC = driver.findElement(By.id("CreditCardType"));
        pickMC.click();
        Select smc = new Select(pickMC);
        smc.selectByVisibleText("Master card");
        driver.findElement(By.id("CardholderName")).sendKeys("Tom Smith");
        driver.findElement(By.id("CardNumber")).sendKeys("1111 2222 3333 4444");
        WebElement expmonth = driver.findElement(By.id("ExpireMonth"));
        Select smonth = new Select(expmonth);
        smonth.selectByVisibleText("12");
        WebElement expyear = driver.findElement(By.id("ExpireYear"));
        Select syear =new Select(expyear);
        syear.selectByVisibleText("2027");
        driver.findElement(By.id("CardCode")).sendKeys("111");
        selectMenu("//div[@id='payment-info-buttons-container']/button");

        verifyPageNavigation("//div[@class='billing-info-wrap']/div[2]/ul/li/span[2]","Credit Card");
        verifyPageNavigation("//li[@class='shipping-method']/span[2]","Next Day Air");
        verifyPageNavigation("//table[@class='cart-total']/tbody/tr[4]/td[2]/span/strong","$2,950.00");
        selectMenu("//div[@id='confirm-order-buttons-container']/button");
        verifyPageNavigation("//div[@class='page-title']/h1","Checkout");
        verifyPageNavigation("//div[@class='section order-completed']/div[1]/strong","Your order has been successfully processed!");
        selectMenu("//div[@class='section order-completed']/div[3]/button");
        verifyPageNavigation("//div[@class='topic-block-title']/h2","Welcome to our store");






    }

}
