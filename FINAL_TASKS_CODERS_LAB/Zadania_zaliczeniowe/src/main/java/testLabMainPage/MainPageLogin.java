package testLabMainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageLogin {

    private WebDriver driver;

    public MainPageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div#_desktop_user_info .hidden-sm-down")
    private WebElement signIn;


    public void signClick() {
        signIn.click();
    }

    @FindBy(id = "field-email")
    private WebElement emailInput;
    @FindBy(id = "field-password")
    private WebElement passwdInput;

    public void loginProccess(String email, String password) {
      emailInput.clear();
      emailInput.sendKeys(email);
      passwdInput.clear();
      passwdInput.sendKeys(password);
    }

    @FindBy(id = "submit-login")
    private WebElement loginButton;

    public void loginButton() {
        loginButton.click();
    }
}
