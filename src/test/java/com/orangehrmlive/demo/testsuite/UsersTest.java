package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestDataForUsersTest;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    AdminPage adminPage;
    ViewSystemUsersPage viewSystemUserPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        viewSystemUserPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        //Login to Application
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        loginPage.setClickOnLogin();

        //	click On "Admin" Tab
        adminPage.setClickOnAdmin();

        //	Verify "System Users" Text
        String actualText = viewSystemUserPage.setVerifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //	click On "Add" button
        viewSystemUserPage.setClickingAddButton();

        //Verify "Add User" Text
        String expectedMessage = "Add User";
        String actualMessage = addUserPage.setVerifyAddUserText().substring(0, expectedMessage.length());
        Assert.assertEquals(actualMessage, expectedMessage, "System User is not displayed");

        //Select User Role "Admin"
        addUserPage.clickOnSelectUserRole();
        addUserPage.setSelectAdmin();

        //enter Employee Name "Ananya Dash"
        addUserPage.setEnterEmployeeName("Paul  Collings");

        //enter Username
        addUserPage.setEnterTheUserName("Priyanka789");

        //Select status "Disable"
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();

        //enter password
        addUserPage.setPassword("admin123");

        //enter Confirm Password
        addUserPage.setConfirmPassword("admin123");

        //click On "Save" Button
        addUserPage.setClickOnSaveButton();

        //verify message "Successfully Saved"
        String expectedMessage1 = "Successfully Saved";
        String actualMessage1 = addUserPage.getTextSuccessfullySaved().substring(0, expectedMessage.length());
        Assert.assertEquals(actualMessage1, expectedMessage1, "Not saved Successfully");
    }

    @Test(groups = {"Smoke", "Regression"})
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {

        //Login to Application
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        loginPage.setClickOnLogin();

        //	click On "Admin" Tab
        adminPage.setClickOnAdmin();

        //	Verify "System Users" Text
        String actualText = viewSystemUserPage.setVerifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //Enter Username
        addUserPage.setEnterTheUserName("Priyanka789");

        //Select User Role
        addUserPage.clickOnSelectUserRole();

        //Select Status
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();

        //Click on "Search" Button
        viewSystemUserPage.setEnterSearch();

        //Verify the User should be in Result list.
        String actualResult = viewSystemUserPage.setVerifyTheResult();
        String expectedResult = "Paul collings";
        Assert.assertEquals(actualResult, expectedResult, "paul collings is not displayed");

    }

    @Test(groups = {"Regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {

        //Login to Application
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        loginPage.setClickOnLogin();

        //	click On "Admin" Tab
        adminPage.setClickOnAdmin();

        //	Verify "System Users" Text
        String actualText = viewSystemUserPage.setVerifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //Enter Username
     //   addUserPage.setEnterTheUserName("Patel123");

        //Select User Role
        addUserPage.clickOnSelectUserRole();

        //Select Status
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();

        //Click on "Search" Button
        viewSystemUserPage.setEnterSearch();

        //Verify the User should be in Result list.
        String actualResult = viewSystemUserPage.setVerifyTheResult();
        String expectedResult = "Paul collings";
        Assert.assertEquals(actualResult, expectedResult, "Linda.Anderson is not displayed");

        //Click on Check box
        viewSystemUserPage.setTickOnCheckbox();

        //Click on Delete Button
        viewSystemUserPage.setClickOnDeleteButton();

        //Popup will display
        viewSystemUserPage.notifyAll();

        //Click on Ok Button on Popup
        viewSystemUserPage.acceptAlert();

        //verify message "Successfully Deleted"
        String expectedMessage1 = "Successfully Deleted";
        String actualMessage1 = viewSystemUserPage.getTextFromAlert().substring(0, expectedMessage1.length());
        Assert.assertEquals(actualMessage1, expectedMessage1, "Successfully Deleted message is not displayed");

    }


    @Test(dataProvider = "SystemUsers", dataProviderClass =  TestDataForUsersTest.class, groups = "regression")
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        //Login to Application
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        loginPage.setClickOnLogin();

        //	click On "Admin" Tab
        adminPage.setClickOnAdmin();

        //	Verify "System Users" Text
        String actualText = viewSystemUserPage.setVerifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //Enter Username
       // addUserPage.setEnterTheUserName("Patel123");

        //Select User Role
        addUserPage.clickOnSelectUserRole();

        //Select Status
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();

        //Click on "Search" Button
        viewSystemUserPage.setEnterSearch();

        //verify message "(1) Record Found"
        String actualResult = viewSystemUserPage.setVerifyTheResult();
        String expectedResult = "Paul collings";
        Assert.assertEquals(actualResult, expectedResult, "Linda.Anderson is not displayed");

        //Verify username <username>
        String expectedUsername = "username";
        String actualUsername = viewSystemUserPage.getTextUsername();
        Assert.assertEquals(expectedUsername, actualUsername);
        //Click on Reset Tab
        viewSystemUserPage.setClickOnResetBtn();
    }
}
