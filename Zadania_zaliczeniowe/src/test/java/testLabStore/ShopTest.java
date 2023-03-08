package testLabStore;

import com.google.common.io.Files;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import shippingPersonalization.AddressCheck;
import shippingPersonalization.PaymentOptions;
import shippingPersonalization.ShippingMethod;
import testLabClothes.BuyClothes;
import testLabClothes.CheckForRabat;
import testLabClothes.CustomizeOrder;
import testLabClothes.NavigateToClothesPage;
import testLabMainPage.MainPageLogin;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ShopTest {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        MainPageLogin mainPageLogin = new MainPageLogin(driver);
        mainPageLogin.signClick();
        mainPageLogin.loginProccess("nowyemail@breiz.com","nowehaslo357");
        mainPageLogin.loginButton();

        NavigateToClothesPage navigateToClothesPage = new NavigateToClothesPage(driver);
        navigateToClothesPage.clothesClick();

        CheckForRabat checkForRabat = new CheckForRabat(driver);
        System.out.println(checkForRabat.discountCheck("-20%"));

        BuyClothes buyClothes = new BuyClothes(driver);
        buyClothes.pickSweater();

        CustomizeOrder customizeOrder = new CustomizeOrder(driver);
        customizeOrder.sizeAndQuantity("L","7");
        customizeOrder.addToCart();
        customizeOrder.proceedToCheckout();

        AddressCheck addressCheck = new AddressCheck(driver);
        Assert.assertEquals("Jan Kowalski\n" +
                "szczecin\n" +
                "szczecin\n" +
                "22-110\n" +
                "United Kingdom",addressCheck.getAddress());
        addressCheck.addressConfirm();

        ShippingMethod shippingMethod = new ShippingMethod(driver);
        shippingMethod.pickPrestaShop();
        shippingMethod.shippingContinue();

        PaymentOptions paymentOptions = new PaymentOptions(driver);
        paymentOptions.payOptionClick();

        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f,new File("C:\\Users\\Dominik\\Downloads\\sample\\testLabScreenshot.jpg"));




        driver.quit();
    }
}
