package testLabAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveAndCheck {

    public SaveAndCheck(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "form-control-submit")
    private WebElement saveButton;

    public void saveClick() {
        saveButton.click();
    }

    @FindBy(xpath = "//*[@id=\"address-31749\"]/div[1]/address")
    private WebElement assAddress;

    public String getAddress() {
        return assAddress.getText();
    }

    @FindBy(css = "div:nth-of-type(2) > .address > .address-footer > a:nth-of-type(2) > span")
    private WebElement deleteAddress;

    public void deleteClick() {
        deleteAddress.click();
    }

}
