package shippingPersonalization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.PanelUI;

public class PaymentOptions {
    private WebDriver driver;

    public PaymentOptions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-module-name=\"ps_checkpayment\"]")
    private WebElement payByCheck;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeToTerms;
    @FindBy(css = ".btn.btn-primary.center-block")
    private WebElement placeOrderButton;
    public void payOptionClick() {
        payByCheck.click();
        agreeToTerms.click();
        placeOrderButton.click();
    }
}
