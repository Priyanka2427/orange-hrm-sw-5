package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
    WebElement VerifyTextSystemUser;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement clickingAddButton;

    @CacheLookup
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement enterUserName;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']" )
    WebElement enterSearch ;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'khilenpatel123')]")
    WebElement  verifyTheResult;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement   tickOnCheckbox ;

    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement   clickOnDeleteButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement clickOnYesDelete;
    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement getTextDeletedMsg;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(64) Records Found']")
    WebElement recordOfUsers;
    @CacheLookup
    @FindBy(xpath ="(//div[@role='cell'])[2]")
    WebElement getUserName;
    @CacheLookup
    @FindBy(className = "oxd-button oxd-button--medium oxd-button--ghost")
    WebElement clickOnResetBtn;

    public String setVerifyTextSystemUser() {
        return getTextFromElement(VerifyTextSystemUser);

    }

    public void setClickingAddButton() {
        clickOnElement(clickingAddButton);
    }

    public void setEnterUsername(String user){
        sendTextToElement(enterUserName,user);
    }

    public void setEnterSearch(){
        clickOnElement(enterSearch);
    }

    public String setVerifyTheResult(){
        return getTextFromElement(verifyTheResult);
    }

    public void setTickOnCheckbox(){
        clickOnElement(tickOnCheckbox);
    }

    public void setClickOnDeleteButton(){
        clickOnElement(clickOnDeleteButton);
    }

    public void setClickOnYesDelete(){
        clickOnElement(clickOnYesDelete);
    }
    public String getTextDeletedMsg(){
        return getTextFromElement(getTextDeletedMsg);
    }
    public String getTextRecord(){
        return getTextFromElement(recordOfUsers);
    }
    public String getTextUsername(){
        return getTextFromElement(getUserName);
    }
    public void setClickOnResetBtn(){
        clickOnElement(clickOnResetBtn);
    }
}
