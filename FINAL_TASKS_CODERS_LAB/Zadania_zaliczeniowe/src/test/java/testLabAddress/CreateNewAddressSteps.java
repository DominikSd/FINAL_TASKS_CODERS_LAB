package testLabAddress;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testLabAccount.AddNewAddress;
import testLabAccount.FilltheForm;
import testLabAccount.SaveAndCheck;
import testLabMainPage.MainPageLogin;
import java.time.Duration;
public class CreateNewAddressSteps {
    private WebDriver driver;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }
    @After
    public void cleanup() {
        driver.quit();
    }
    @When("user click 'sign in' and log into account using {} and {}")
    public void logIntoAcc(String email, String password) {

        MainPageLogin mainPageLogin = new MainPageLogin(driver);
        mainPageLogin.signClick();
        mainPageLogin.loginProccess(email, password);
        mainPageLogin.loginButton();
    }
    @Then("user create new address and fills out the form with {}, {}, {}, {}, {}")
    public void createNewAddress(String alias, String address, String city, String zipPostalCode, String phone) {
        AddNewAddress addNewAddress = new AddNewAddress(driver);
        addNewAddress.goToAddresses();
        addNewAddress.createNewAddress();

        FilltheForm filltheForm = new FilltheForm(driver);
        filltheForm.fillingForm(alias, address, city, zipPostalCode, phone);
    }
    @And("user click on save button and check if every date is correct")
    public void saveAndAssert() {
        SaveAndCheck saveAndCheck = new SaveAndCheck(driver);
        saveAndCheck.saveClick();
        Assert.assertEquals("Jan Kowalski\n" +
                "szczecin\n" +
                "szczecin\n" +
                "22-110\n" +
                "United Kingdom",saveAndCheck.getAddress());
    }
    @Then("user delete new address")
    public void deleteAndAssert() {
        SaveAndCheck saveAndCheck = new SaveAndCheck(driver);
        saveAndCheck.deleteClick();
        Assert.assertNotEquals(saveAndCheck.getAddress(), "");
    }
}