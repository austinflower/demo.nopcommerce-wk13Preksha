package Electronics;

import browsertesting.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElectronicsTest extends BaseTest {

    String baseUrl ="https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void textverified(){
        Actions actions = new Actions(driver);

        WebElement electronics = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        WebElement cellphone =driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul/li[2]/a"));
        actions.moveToElement(electronics).moveToElement(cellphone).click().build().perform();
        verifyPageNavigation("//div[@class='page category-page']/div[1]/h1","Cell phones");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement electronics = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        WebElement cellphone =driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul/li[2]/a"));
        actions.moveToElement(electronics).moveToElement(cellphone).click().build().perform();
        //2.3 Verify the text “Cell phones”
        verifyPageNavigation("//div[@class='page category-page']/div[1]/h1","Cell phones");
        //2.4 Click on List View Tab
        selectMenu("//div[@class='product-viewmode']/a[2]");
        Thread.sleep(2000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        selectMenu("//div[@class='item-grid']/div[3]/div/div[2]/h2/a");
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyPageNavigation("//div[@class='product-name']/h1","Nokia Lumia 1020");
        //2.7 Verify the price “$349.00”
        verifyPageNavigation("//div[@class='overview']/div[5]/div/span","$349.00");
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/input")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/input")).sendKeys("2");
        //2.9 Click on “ADD TO CART” tab
        selectMenu("//div[@class='add-to-cart-panel']/button");
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar
        verifyPageNavigation("//div[@class='bar-notification success']/p","The product has been added to your shopping cart");
        Thread.sleep(2000);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        driver.findElement(By.xpath("//div[@id='bar-notification']/div/span")).click();
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]/a/span[1]")).click();
        //2.12 Verify the message "Shopping cart"
        verifyPageNavigation("//div[@class='page-title']/h1","Shopping cart");
        Thread.sleep(5000);
        //2.13 Verify the quantity is 2
        verifyPageNavigation("//div[@class='table-wrapper']/table/tbody/tr/td[5]/input","");
        //2.14 Verify the Total $698.00
        verifyPageNavigation("//div[@class='table-wrapper']/table/tbody/tr/td[6]","$698.00");
        //2.15 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        //2.16 Click on checkout
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        //“2.17 Verify the Text “Welcome, Please Sign In!”
        verifyPageNavigation("//div[@class='page-title']/h1","Welcome, Please Sign In!");
        //2.18 Click on “REGISTER” tab
        driver.findElement(By.xpath("//button[@class='button-1 register-button']")).click();
        //2.19 Verify the text “Register”
        verifyPageNavigation("//div[@class='page registration-page']/div[1]/h1","Register");
        //2.20 Fill the mandatory fields
        driver.findElement(By.id("FirstName")).sendKeys("Tom");
        driver.findElement(By.id("LastName")).sendKeys("Smith");
        driver.findElement(By.id("Email")).sendKeys("tomsmith1015@aol.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        //2.21 Click on “REGISTER” Button
        driver.findElement(By.id("register-button")).click();
        //2.22 Verify the message “Your registration completed”
        verifyPageNavigation("//div[@class='page-body']/div","Your registration completed");
        //2.23 Click on “CONTINUE” tab
        selectMenu("//div[@class='buttons']/a");
        //2.22 Verify the message “Your registration completed”
        //2.24 Verify the text “Shopping cart”
        verifyPageNavigation("//div[@class='page-title']/h1", "Shopping cart");
        //Needed to login with the above id and password
        selectMenu("//div[@class='header-links']/ul/li[2]/a");
        driver.findElement(By.id("Email")).sendKeys("tomsmith1015@aol.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        selectMenu("//button[@class='button-1 login-button']");
        //2.25 click on checkbox “I agree with the terms of service”
        selectMenu("//div[@class='terms-of-service']/input");
        //2.26 Click on “CHECKOUT”
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(3000);
        //2.27 Fill the Mandatory fields
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
        //2.28 Click on “CONTINUE”
        selectMenu("//div[@id='billing-buttons-container']/button[4]");
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        driver.findElement(By.id("shippingoption_2")).click();
        //2.30 Click on “CONTINUE”
        selectMenu("//div[@id='shipping-method-buttons-container']/button");
        //2.31 Select Radio Button “Credit Card”
        driver.findElement(By.id("paymentmethod_1")).click();
        driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/button")).click();
        //2.32 Select “Visa” From Select credit card dropdown
        WebElement pickVisa = driver.findElement(By.id("CreditCardType"));
        pickVisa.click();
        Select svisa = new Select(pickVisa);
        svisa.selectByVisibleText("Visa");
        //2.33 Fill all the details
        driver.findElement(By.id("CardholderName")).sendKeys("Tommy Smith");
        driver.findElement(By.id("CardNumber")).sendKeys("1111 2222 3333 4444");
        WebElement expmonth = driver.findElement(By.id("ExpireMonth"));
        Select smonth = new Select(expmonth);
        smonth.selectByVisibleText("11");
        WebElement expyear = driver.findElement(By.id("ExpireYear"));
        Select syear =new Select(expyear);
        syear.selectByVisibleText("2030");
        driver.findElement(By.id("CardCode")).sendKeys("222");
        //2.34 Click on “CONTINUE”CHECKOUT”
        selectMenu("//div[@id='payment-info-buttons-container']/button");
//2.35 Verify “Payment Method” is “Credit Card”
//2.36 Verify “Shipping Method” is “2nd Day Air”
//2.37 Verify Total is “$698.00”
//2.38 Click on “CONFIRM”
//2.39 Verify the Text “Thank You”
//2.40 Verify the message “Your order has been successfully processed!”
//2.41 Click on “CONTINUE”
//2.42 Verify the text “Welcome to our store”
//2.43 Click on “Logout” link
//2.44 Verify the URL is “https://demo.nopcommerce.com
        verifyPageNavigation("//div[@class='billing-info-wrap']/div[2]/ul/li/span[2]","Credit Card");
        verifyPageNavigation("//li[@class='shipping-method']/span[2]","2nd Day Air");
        verifyPageNavigation("//table[@class='cart-total']/tbody/tr[4]/td[2]/span/strong","$698.00");
        selectMenu("//div[@id='confirm-order-buttons-container']/button");
        verifyPageNavigation("//div[@class='page-title']/h1","Checkout");
        verifyPageNavigation("//div[@class='section order-completed']/div[1]/strong","Your order has been successfully processed!");
        selectMenu("//div[@class='section order-completed']/div[3]/button");
        verifyPageNavigation("//div[@class='topic-block-title']/h2","Welcome to our store");







    }










}
