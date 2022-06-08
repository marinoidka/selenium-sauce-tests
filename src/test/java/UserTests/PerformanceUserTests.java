package UserTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.marinoidka.pages.LoginPage;
import ru.marinoidka.tests.BaseTest;
import ru.marinoidka.tests.OrderingTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.marinoidka.tests.BaseTest.*;
@Epic("Пользовательские тесты")
@Story("Тесты с логином {performance.user}")

public class PerformanceUserTests extends BaseTest {
    public static String performanceUser = properties.getProperty("performance.user");


    @Step("Авторизируемся с логином {performance.user} и паролем {password}")
    @Test
    void authorisationWithPerformanceLoginTest() {
        new LoginPage(driver)
                .enterLogin(performanceUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @Step("Делаем заказ {productID} от performanceUser")
    @Test
    void orderingTest() {
        new LoginPage(driver)
                .enterLogin(performanceUser)
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
