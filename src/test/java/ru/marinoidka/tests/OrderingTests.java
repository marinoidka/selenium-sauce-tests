package ru.marinoidka.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import ru.marinoidka.pages.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("Основные тесты")
@Feature("Тесты на оформление заказа")

public class OrderingTests extends BaseTest{

    @Step("Успешный сценарий заказа со стандартным логином {username} и паролем {password}.")
    @Test
    void successfulOrderingPositiveTest() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .getProduct(productID)
                .clickCart()
                .clickCheckout()
                .setFirstname(firstname)
                .setLastname(lastname)
                .setPostCode(postcode)
                .clickContinue()
                .clickFinish();
        assertThat(driver.getCurrentUrl(), equalTo(checkoutCompleteURL));
    }

}
