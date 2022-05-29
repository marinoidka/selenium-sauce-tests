package ru.marinoidka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public CheckoutPage clickCheckout() {
        driver.findElement(By.name("checkout")).click();
        return new CheckoutPage(driver);
    }
}
