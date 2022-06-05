package tech;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import ru.marinoidka.pages.InventoryPage;
import ru.marinoidka.pages.LoginPage;
import ru.marinoidka.tests.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.marinoidka.elements.SortingDropDownValues.NAME_ASC;

@Slf4j
@Epic("Технические тесты")
@Story("Тесты на удаление/добавление cookie")
public class CookiesTests extends BaseTest {

    @Step("")
    @Test
        // тест должен падать, так как мы подставляем сломанного пользователя
    void setCookiesTest() {
        InventoryPage inventoryPage = new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .getProduct(productID);
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("session-username", "locked_out_user", "/"));
// тест должен падать
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
    }


}