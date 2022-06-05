package ru.marinoidka.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPage extends BasePage{
    @FindBy(css = ".header_secondary_container")
    WebElement secondaryContainer;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    @Step("Проверяем наличие контейнера с надписью Checkout")
    public void checkSecondaryContainer() {
        assertThat(secondaryContainer.getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
    }

    @Step("Заполняем {firstname}")
    public CheckoutPage setFirstname(String firstname) {
        driver.findElement(By.cssSelector("[data-test='firstName']")).click();
        driver.findElement(By.cssSelector("[data-test='firstName']")).sendKeys(firstname);
        return this;
    }
    @Step("Заполняем {lastname}")
    public CheckoutPage setLastname(String lastname) {
        driver.findElement(By.cssSelector("[data-test='lastName']")).click();
        driver.findElement(By.cssSelector("[data-test='lastName']")).sendKeys(lastname);
        assertThat(driver.findElement(By.cssSelector("[data-test='lastName']")).getAttribute("value"), equalTo(lastname));
        return this;
    }
    @Step("Заполняем {postcode}")
    public CheckoutPage setPostCode(String postcode) {
        driver.findElement(By.cssSelector("[data-test='postalCode']")).click();
        driver.findElement(By.cssSelector("[data-test='postalCode']")).sendKeys(postcode);
        assertThat(driver.findElement(By.cssSelector("[data-test='postalCode']")).getAttribute("value"), equalTo(postcode));
        return this;
    }
    @Step("Нажимаем кнопку continue")
    public CheckoutOverviewPage clickContinue() {
        driver.findElement(By.id("continue")).click();
        return new CheckoutOverviewPage(driver);
    }
    @Step("Проверяем бейдж корзины")
    public void checkShoppingCartBadge() {
        assertThat(driver.findElement(By.className("shopping_cart_badge")).isDisplayed(), equalTo(true));
    }
    @Step("Проверяем бейдж корзины с одним товаром")
    public void checkShoppingCartBadgeOneProduct(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
    }
    @Step("Проверяем info container")
    public void checkInfoContainer() {
        assertThat(driver.findElement(By.className("checkout_info_container")).isDisplayed(), equalTo(true));
    }
    @Step("Проверяем error container")
    public void checkErrorMessageContainer() {
        assertThat(driver.findElement(By.className("error-message-container")).isDisplayed(), equalTo(true));
    }
    @Step("Проверяем error message____")
    public void checkErrorMessage() {
        assertThat(driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed(), equalTo(true));
    }
    @Step("Проверяем checkout кнопки")
    public void checkCheckoutButtons() {
        assertThat(driver.findElement(By.className("checkout_buttons")).isDisplayed(), equalTo(true));
    }
    @Step("Проверяем кнопку cancel в checkout")
    public CheckoutPage checkCancelCheckoutButton () {
        assertThat(driver.findElement(By.cssSelector("[data-test='cancel']")).getText(), equalTo("CANCEL"));
        assertThat(driver.findElement(By.className("back-image")).isDisplayed(), equalTo(true));
        driver.findElement(By.cssSelector("[data-test='cancel']")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }
    @Step("Проверяем кнопку continue в checkout")
    public CheckoutPage checkContinueCheckoutButton (String firstname, String lastname, String postcode) {
        assertThat(driver.findElement(By.cssSelector("[data-test='continue']")).getAttribute("value"), equalTo("Continue"));
        setFirstname(firstname);
        setLastname(lastname);
        setPostCode(postcode);
        driver.findElement(By.id("continue")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }

}
