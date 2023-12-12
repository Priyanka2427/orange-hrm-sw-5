package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        adminPage = new AdminPage();

    }

    @Test(groups = {"Sanity", "Smoke", "Regression"})
    public void verifyUserShouldLoginSuccessfully() {
        //Enter username
        homePage.setEnterUserName("Admin");
        //   Enter password
        homePage.setEnterPassword("admin123");
        //   Click on Login Button
        loginPage.setClickOnLogin();
        //   Verify "Dashboard" Message
        String actualMessage = dashboardPage.getVerifyTheTextDashboard();
        String expectedMessage = "Dashboard";
        Assert.assertEquals(actualMessage, expectedMessage, "WelCome Text is displayed");

    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyThatTheLogoDisplayedOnLoginPage() {
        //Launch the application
        driver.getCurrentUrl();
        //   Verify Logo is Displayed
        homePage.setHrmLogo();
    }

    @Test(groups = {"Regression"})
    public void verifyUserShouldLogoutSuccessfully() throws InterruptedException {
        //Login To The application
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        loginPage.setClickOnLogin();
        //   Click on User Profile logo
        adminPage.setClickOnUserProfileLogo();
        //   Mouse hover on "Logout" and click
        adminPage.setMouseHoverOnLogout();
        //   Verify the text "Login Panel" is displayed
        Thread.sleep(2000);
        String actualMessage = homePage.setVerifyLoginPanel();
        String expectedMessage = "Login";
        Assert.assertEquals(actualMessage, expectedMessage, "login message is not displayed");

    }

    @Test(groups = {"Regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        //Enter username
        homePage.setEnterUserName("promo123@yahoo.com");
        //   Enter password
        homePage.setEnterPassword("promo");
        //   Click on Login Button
        loginPage.setClickOnLogin();
        //   Verify "Dashboard" Message
        String actualMessage = dashboardPage.getVerifyTheTextDashboard();
        String expectedMessage = "Welcome  Text is not displayed";
        Assert.assertEquals(actualMessage, expectedMessage, "Welcome  Text is not displayed");
    }
}


