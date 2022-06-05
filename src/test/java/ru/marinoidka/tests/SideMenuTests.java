package ru.marinoidka.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.LoginPage;
import ru.marinoidka.pages.SideMenu;

@Epic("Основные тесты")
@Feature("Тесты на боковое меню")
public class SideMenuTests extends BaseTest{
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

    @Test
    void shouldClickSideMenuAllItems() {
        new SideMenu(driver)
                .clickSideMenuAllItems();
    }

    /*@Test
    void shouldClickSideMenuAbout() {
        new SideMenu(driver)
                .clickSideMenuAbout();
    }*/

    @Test
    void shouldClickSideMenuLogout() {
        new SideMenu(driver)
                .clickSideMenuLogout();
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Test
    void shouldClickSideMenuReset() {
        new SideMenu(driver)
                .clickSideMenuReset();
    }

    @Test
    void shouldClickSideMenuCrossButton() {
        new SideMenu(driver)
                .clickSideMenuCrossButton();
        driver.get(properties.getProperty("inventory.page.url"));
    }

    @Step("Разлогин")
    @AfterEach
    public void logOut() {
        new BaseAuthorisedPage(driver)
                .logOut();
    }
}
