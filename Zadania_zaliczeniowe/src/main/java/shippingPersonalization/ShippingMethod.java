package shippingPersonalization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethod {
    private WebDriver driver;

    public ShippingMethod(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span")
    private WebElement pickUpInStore;
    @FindBy(xpath = "//*[@name=\"confirmDeliveryOption\"]")
    private WebElement shipContinue;
    public void pickPrestaShop() {
        pickUpInStore.click();
    }

    public void shippingContinue() {
        shipContinue.click();
    }
}
