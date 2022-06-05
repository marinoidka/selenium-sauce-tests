package ru.marinoidka.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }
    @Step("Нажимаем кнопку Checkout")
    public CheckoutPage clickCheckout() {
        driver.findElement(By.name("checkout")).click();
        return new CheckoutPage(driver);
    }
}
