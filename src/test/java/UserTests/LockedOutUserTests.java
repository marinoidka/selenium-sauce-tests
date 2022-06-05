package UserTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.marinoidka.pages.LoginPage;
import ru.marinoidka.tests.BaseTest;
import ru.marinoidka.tests.OrderingTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.marinoidka.pages.LoginPage.loginInput;
import static ru.marinoidka.pages.LoginPage.passwordInput;
import static ru.marinoidka.tests.BaseTest.*;
@Epic("Пользовательские тесты")
@Story("Тесты с логином {locked.username}")

public class LockedOutUserTests extends BaseTest {
    public static String lockedUsername = properties.getProperty("locked.username");


    @Step("Авторизируемся с логином {locked.username} и паролем {password}")
    @Test
    void authorisationWithLockedOutLoginTest() {
        new LoginPage(driver)
                .enterLogin(lockedUsername)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @Step("Делаем заказ {productID} от {lockedUsername}")
    @Test
    void orderingTest() {
        new LoginPage(driver)
                .enterLogin(lockedUsername)
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

    @AfterEach
    void cleanUp() {
        loginInput.clear();
        passwordInput.clear();
    }

}
