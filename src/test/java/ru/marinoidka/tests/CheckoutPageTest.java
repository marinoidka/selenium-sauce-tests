package ru.marinoidka.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import ru.marinoidka.elements.FooterPageElements;
import ru.marinoidka.elements.SideMenuElements;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.CheckoutPage;
import ru.marinoidka.pages.LoginPage;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
@Epic("Основные тесты")
@Feature("Тесты на страницу Checkout")
class CheckoutPageTest extends BaseTest {

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
    void shouldFindHeaderLabelTest() {
        new BaseAuthorisedPage(driver)
                .checkHeaderLabel();
    }

    @Test
    void shouldFindLogoTest() {
        new BaseAuthorisedPage(driver)
                .checkHeaderLogo();
    }

    @Test
    void shouldFindShoppingCartTest() {
        new BaseAuthorisedPage(driver)
                .checkShoppingCartContainer();
    }

    @Test
    void shouldFindShoppingCartLinkTest() {
        new BaseAuthorisedPage(driver)
                .checkShoppingCartLink();
    }

    @Test
    void shouldFindShoppingCartBadgeTest() {
        new CheckoutPage(driver)
                .checkShoppingCartBadge();
    }

    @Test
    void shouldFindHeaderSecondaryContainerTest() {
        new CheckoutPage(driver)
                .checkSecondaryContainer();
    }

    @Test
    void shouldFindCheckoutInfoContainerTest() {
        new CheckoutPage(driver)
                .checkInfoContainer();
    }

    @Test
    void shouldFindFirstnameTest() {
        new CheckoutPage(driver)
                .setFirstname(firstname);
    }

    @Test
    void shouldFindLastnameTest() {
        new CheckoutPage(driver)
                .setLastname(lastname);
    }

    @Test
    void shouldFindZipCodeTest() {
        new CheckoutPage(driver)
                .setPostCode(postcode);
    }

    @Test
    void shouldFindErrorMessageContainerTest() {
        new CheckoutPage(driver)
                .checkErrorMessageContainer();
    }

    @Test
    void shouldDisplayErrorMessage() {
        new CheckoutPage(driver)
                .clickContinue();
        new CheckoutPage(driver)
                .checkErrorMessage();
    }

    @Test
    void shouldFindCheckoutBtnsTest() {
        new CheckoutPage(driver)
                .checkCheckoutButtons();
    }

    @Test
    void shouldFindCancelBtnTest() {
        new CheckoutPage(driver)
                .checkCancelCheckoutButton();
    }

    @Test
    void shouldFindContinueBtnTest() {
        new CheckoutPage(driver)
                .checkContinueCheckoutButton(firstname, lastname, postcode);
    }


    @Step("Разлогин")
    @AfterEach
    public void logOut() {
        new BaseAuthorisedPage(driver)
                .logOut();
    }




}
