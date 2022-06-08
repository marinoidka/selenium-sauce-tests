package ru.marinoidka.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.LoginPage;

@Epic("Тесты на авторизацию")
@Feature("Тесты на авторизацию разных уровней пользователей")
class AuthorisationTests extends BaseTest {

    @Step("Авторизиремся со стандартным логином {username} и паролем {password}")
    @Test
    void authorisationWithLoginPositiveTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @Step("Разлогин")
    @AfterEach
    public void logOut() {
        new BaseAuthorisedPage(driver)
                .logOut();
    }




}
