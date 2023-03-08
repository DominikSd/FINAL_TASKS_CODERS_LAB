package testLabClothes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigateToClothesPage {
    private WebDriver driver;

    public NavigateToClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "CLOTHES")
    private WebElement clothesButton;
    public void clothesClick() {
        clothesButton.click();
    }
}
