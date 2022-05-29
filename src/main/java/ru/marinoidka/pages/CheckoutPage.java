package ru.marinoidka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public CheckoutPage setFirstname() {
        driver.findElement(By.cssSelector("[data-test='firstName']")).click();
        driver.findElement(By.cssSelector("[data-test='firstName']")).sendKeys("Marina");
        assertThat(driver.findElement(By.cssSelector("[data-test='firstName']")).getAttribute("value"), equalTo("Marina"));
        return this;
    }

    public CheckoutPage setLastname() {
        driver.findElement(By.cssSelector("[data-test='lastName']")).click();
        driver.findElement(By.cssSelector("[data-test='lastName']")).sendKeys("Chernykh");
        assertThat(driver.findElement(By.cssSelector("[data-test='lastName']")).getAttribute("value"), equalTo("Chernykh"));
        return this;
    }

    public CheckoutPage setPostCode() {
        driver.findElement(By.cssSelector("[data-test='postalCode']")).click();
        driver.findElement(By.cssSelector("[data-test='postalCode']")).sendKeys("426000");
        assertThat(driver.findElement(By.cssSelector("[data-test='postalCode']")).getAttribute("value"), equalTo("426000"));
        return this;
    }

    public CheckoutOverviewPage clickContinue() {
        driver.findElement(By.id("continue")).click();
        return new CheckoutOverviewPage(driver);
    }

    public void checkShoppingCartBadge() {
        assertThat(driver.findElement(By.className("shopping_cart_badge")).isDisplayed(), equalTo(true));
    }

    public void checkInfoContainer() {
        assertThat(driver.findElement(By.className("checkout_info_container")).isDisplayed(), equalTo(true));
    }

    public void checkErrorMessageContainer() {
        assertThat(driver.findElement(By.className("error-message-container")).isDisplayed(), equalTo(true));
    }

    public void checkErrorMessage() {
        assertThat(driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed(), equalTo(true));
    }

    public void checkCheckoutButtons() {
        assertThat(driver.findElement(By.className("checkout_buttons")).isDisplayed(), equalTo(true));
    }

    public CheckoutPage checkCancelCheckoutButton () {
        assertThat(driver.findElement(By.cssSelector("[data-test='cancel']")).getText(), equalTo("CANCEL"));
        assertThat(driver.findElement(By.className("back-image")).isDisplayed(), equalTo(true));
        driver.findElement(By.cssSelector("[data-test='cancel']")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }

    public CheckoutPage checkContinueCheckoutButton () {
        assertThat(driver.findElement(By.cssSelector("[data-test='continue']")).getAttribute("value"), equalTo("Continue"));
        setFirstname();
        setLastname();
        setPostCode();
        driver.findElement(By.id("continue")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }

}
