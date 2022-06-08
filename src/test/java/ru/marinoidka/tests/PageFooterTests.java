package ru.marinoidka.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.CheckoutPage;
import ru.marinoidka.pages.LoginPage;
@Epic("Основные тесты")
@Feature("Тесты на подвал страницы")
public class PageFooterTests extends BaseTest{
    @Step("Логинимся, выбираем продукт и переходим в Checkout.")
    @BeforeEach
    void goCheckout() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .getProduct(productID)
                .clickCart()
                .clickCheckout();
    }

    @Step("Переходим в LinkedIn")
    @Test
    void goToLinkedInTest(){
        new BaseAuthorisedPage(driver)
                .goToLinkedIn();
    }

    @Step("Переходим в Twitter")
    @Test
    void goToTwitterTest(){
        new BaseAuthorisedPage(driver)
                .goToTwitter();
    }

    @Step("Переходим в Facebook")
    @Test
    void goToFacebookTest(){
        new BaseAuthorisedPage(driver)
                .goToFacebook();
    }

    @Step("Проверем копирайт")
    @Test
    void shouldFindCopyTest() {
        new BaseAuthorisedPage(driver)
                .checkFooterCopy();
    }

    @Step("Проверем робота")
    @Test
    void shouldFindRobotTest() {
        new BaseAuthorisedPage(driver)
                .checkFooterRobot();
    }

    @Step("Разлогин")
    @AfterEach
    public void logOut() {
        new BaseAuthorisedPage(driver)
                .logOut();
    }


}
