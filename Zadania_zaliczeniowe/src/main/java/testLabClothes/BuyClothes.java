package testLabClothes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyClothes {
    private WebDriver driver;
    public BuyClothes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = " img[alt='Brown bear printed sweater']")
    private WebElement sweaterLink;

    public void pickSweater() {
        sweaterLink.click();
    }
}
