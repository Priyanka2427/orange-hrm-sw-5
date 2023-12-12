package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']" )
    WebElement verifyAddUserText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'oxd-select-wrapper'])[1]" )
    WebElement selectUserRole;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement selectAdmin;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']" )
    WebElement enterEmployeeName;

    @CacheLookup
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement enterTheUserName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']" )
    WebElement selectStatus;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Disabled')]")
    WebElement selectDisable;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement setPassword;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//font[contains(text(),'Save')]")
    WebElement clickOnSaveButton;


    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successfullySavedMessageInAddUser;


   public String setVerifyAddUserText(){
       return getTextFromElement(verifyAddUserText);
    }

    public void clickOnSelectUserRole() {
        clickOnElement(selectUserRole);
    }

    public void setSelectAdmin(){
        selectByContainsTextFromDropDown((By) selectAdmin,"Admin");
    }

    public void setEnterEmployeeName(String name){
        sendTextToElement(enterEmployeeName, name);
    }

    public void setEnterTheUserName(String userName){
       sendTextToElement(enterTheUserName,userName);
    }

    public void setSelectStatus(){
       clickOnElement(selectStatus);
    }
    public void setSelectDisable(){
       selectByIndexFromDropDown(selectDisable,0);
    }

    public void setPassword(String password){
       sendTextToElement(setPassword,password);
    }

    public void setConfirmPassword(String password){
       sendTextToElement(confirmPassword,password);
    }

    public void setClickOnSaveButton(){
        clickOnElement(clickOnSaveButton);
    }

    public String getTextSuccessfullySaved() {
        return getTextFromElement(successfullySavedMessageInAddUser);
    }

}
