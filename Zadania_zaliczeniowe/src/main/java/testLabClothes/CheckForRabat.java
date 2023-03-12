package testLabClothes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class CheckForRabat {
    private WebDriver driver;
    public CheckForRabat(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/ul/li")
    private WebElement discountSweater;

    public String discountCheck(String negativeAmountInPercent) {
        if (Objects.equals(discountSweater.getText(), negativeAmountInPercent)) {
            System.out.println("+");
        }else System.out.println("-");
        return "Discount for this product is " + discountSweater.getText();
    }
}
