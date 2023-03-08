package testLabAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilltheForm {
    private WebDriver driver;

    public FilltheForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    private WebElement aliasField;
    @FindBy(id = "field-address1")
    private WebElement addressField;
    @FindBy(id = "field-city")
    private WebElement cityField;
    @FindBy(id = "field-postcode")
    private WebElement postcodeField;
    @FindBy(id = "field-id_country")
    private WebElement countrySelect;
    @FindBy(xpath = "//*[@id=\"field-id_country\"]/option[2]")
    private WebElement selectUnitedKingdom;
    @FindBy(id = "field-phone")
    private WebElement phoneField;

    public void fillingForm(String alias, String address, String city, String zipPostalCode, String phone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aliasField));
        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        postcodeField.sendKeys(zipPostalCode);
        countrySelect.click();
        selectUnitedKingdom.click();
        phoneField.sendKeys(phone);
    }
}
