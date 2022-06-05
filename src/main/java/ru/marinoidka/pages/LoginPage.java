package ru.marinoidka.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-test='username']")
    public static WebElement loginInput;
    @FindBy(name = "password")
    public static WebElement passwordInput;
    @FindBy(css = "[data-test='login-button']")
    public static WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вводим логин {loginName}")
    public LoginPage enterLogin(String loginName) {
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }
    @Step("Вводим пароль {password}")
    public LoginPage enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("Кликаем на кнопку 'Авторизоваться'")
    public InventoryPage clickLoginButton() {
        loginButton.click();
        return new InventoryPage(driver);
    }
}
