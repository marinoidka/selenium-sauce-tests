package UserTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.LoginPage;
import ru.marinoidka.tests.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
@Epic("Пользовательские тесты")
@Story("Тесты с логином {problem.user}")

public class ProblemUserTests extends BaseTest {
    public static String problemUser = properties.getProperty("problem.user");

    @Step("Авторизируемся с логином {problem.user} и паролем {password}")
    @Test
    void authorisationWithProblemUserLoginTest() {
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
                .checkCartOnThePage();
    }

    @Step("Делаем заказ {productID} от {problem.user}")
    @Test
    void orderingTest() {
        new LoginPage(driver)
                .enterLogin(problemUser)
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

    @Step("Разлогин")
    @AfterEach
    public void logOut() {
        new BaseAuthorisedPage(driver)
                .logOut();
    }
}
