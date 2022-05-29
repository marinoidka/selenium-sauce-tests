package ru.marinoidka.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.marinoidka.tests.BaseTest.password;
import static ru.marinoidka.tests.BaseTest.username;

class AuthorisationTests extends BaseTest {


    @Test
    void authorisationWithLoginPositiveTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }


    @Test
    void successfulOrderingPositiveTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .getProduct()
                .clickCart()
                .clickCheckout()
                .setFirstname()
                .setLastname()
                .setPostCode()
                .clickContinue()
                .clickFinish();
        assertThat(driver.getCurrentUrl(), equalTo(properties.getProperty("checkout.complete.url")));

    }

    @AfterEach
    void tearDown() {
        new BaseAuthorisedPage(driver)
                .tearDown();
    }

}
