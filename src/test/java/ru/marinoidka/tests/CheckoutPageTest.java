package ru.marinoidka.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import ru.marinoidka.elements.FooterPageElements;
import ru.marinoidka.elements.SideMenuElements;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.CheckoutPage;
import ru.marinoidka.pages.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static ru.marinoidka.utils.TabUtils.switchToTheNextTab;


class CheckoutPageTest extends BaseTest implements FooterPageElements, SideMenuElements {

    @BeforeEach
    void goCheckout() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .getProduct()
                .clickCart()
                .clickCheckout();
    }


    @Test
    void shouldFindSideMenuButton() {
        new BaseAuthorisedPage(driver)
                .checkSideMenuButton();
    }

    @Test
    void shouldClickSideMenuAllItems() {
        new BaseAuthorisedPage(driver)
                .clickSideMenuAllItems();
    }

    @Test
    void shouldClickSideMenuAbout() {
        new BaseAuthorisedPage(driver)
                .clickSideMenuAbout();
    }

    @Test
    void shouldClickSideMenuLogout() {
        new BaseAuthorisedPage(driver)
                .clickSideMenuLogout();
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Test
    void shouldClickSideMenuReset() {
        new BaseAuthorisedPage(driver)
                .clickSideMenuReset();
    }

    @Test
    void shouldClickSideMenuCrossButton() {
        new BaseAuthorisedPage(driver)
                .clickSideMenuCrossButton();
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
        new BaseAuthorisedPage(driver)
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
                .setFirstname();
    }

    @Test
    void shouldFindLastnameTest() {
        new CheckoutPage(driver)
                .setLastname();
    }

    @Test
    void shouldFindZipCodeTest() {
        new CheckoutPage(driver)
                .setPostCode();
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
                .checkContinueCheckoutButton();
    }

    @Test
    void shouldFindTwitterLinkTest() {
        new BaseAuthorisedPage(driver)
                .goToTwitter();
    }

    @Test
    void shouldFindFacebookLinkTest() {
        new BaseAuthorisedPage(driver)
                .goToFacebook();
    }

    @Test
    void shouldFindLinkedinLinkTest() {
        new BaseAuthorisedPage(driver)
                .goToLinkedIn();
    }

    @Test
    void shouldFindCopyTest() {
        new BaseAuthorisedPage(driver)
                .checkFooterCopy();
    }

    @Test
    void shouldFindRobotTest() {
        new BaseAuthorisedPage(driver)
                .checkFooterRobot();
    }


    @AfterEach
    void tearDown() {
        new BaseAuthorisedPage(driver)
                .tearDown();
    }

}
