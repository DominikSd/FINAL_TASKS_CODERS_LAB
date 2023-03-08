package testLabClothes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Objects;

public class CustomizeOrder {
    private WebDriver driver;

    public CustomizeOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "form-control-select")
    private WebElement sizeOption;
    @FindBy(className = "touchspin-up")
    private WebElement quantityUp;
    @FindBy(className = "add-to-cart")
    private WebElement cartButton;
    @FindBy(css = ".product-variants-item > .control-label")
    private WebElement sizeChecker;

    public void sizeAndQuantity(String Size, int quantity) {
        sizeOption.click();
        if (Objects.equals(Size, "S")) {
           driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[@title=\"S\"]")).click();
        }
        else if (Objects.equals(Size, "M")) {
            driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[@title=\"M\"]")).click();
        } else if (Objects.equals(Size, "L")) {
            driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[@title=\"L\"]")).click();
        } else if (Objects.equals(Size, "XL")) {
            driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[@title=\"XL\"]")).click();
        } else throw new IllegalArgumentException("Pick one of these: S / M / L / XL");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(sizeChecker, "Size: " + Size));
        for (int i = 1; i < quantity; i++) {
            quantityUp.click();
        }
    }

    public void addToCart() {
        cartButton.click();
    }

    @FindBy(css = ".cart-content-btn .btn-primary")
    private WebElement checkoutButton;
    public void proceedToCheckout() {
        checkoutButton.click();
        driver.findElement(By.linkText("PROCEED TO CHECKOUT")).click();
    }
}
