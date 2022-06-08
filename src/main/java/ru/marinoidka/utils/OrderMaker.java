package ru.marinoidka.utils;

import org.openqa.selenium.WebDriver;
import ru.marinoidka.pages.BaseAuthorisedPage;
import ru.marinoidka.pages.BasePage;
import ru.marinoidka.pages.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class OrderMaker extends BaseAuthorisedPage {


    public OrderMaker(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public static void successfulOrderingPositiveTest
            (String username, String password, String productID, String firstname, String lastname, String postcode, String checkoutCompleteURL) {
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
