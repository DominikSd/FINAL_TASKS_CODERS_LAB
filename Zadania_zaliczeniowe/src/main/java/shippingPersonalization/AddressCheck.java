package shippingPersonalization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressCheck {
    private WebDriver driver;

    public AddressCheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".address")
    private WebElement addressDate;
    @FindBy(xpath = "//button[@name=\"confirm-addresses\"]")
    private WebElement addressContinue;

    public String getAddress() {
        return addressDate.getText();
    }

    public void addressConfirm() {
        addressContinue.click();
    }

}
