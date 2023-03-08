package testLabAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddNewAddress {

    public AddNewAddress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "addresses-link")
    private WebElement myAddresses;



    public void goToAddresses() {
        myAddresses.click();
    }

    @FindBy(css = "[data-link-action='add-address'] span")
    private WebElement createAddress;

    public void createNewAddress() {
        createAddress.click();
    }

}
