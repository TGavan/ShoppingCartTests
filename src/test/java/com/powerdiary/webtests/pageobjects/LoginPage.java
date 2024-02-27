package com.powerdiary.webtests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(css = "input#email")
    private WebElement emailTextBox;

    @FindBy(css = "input#pass")
    private WebElement passwordTextBox;

    @FindBy(css = "button#send2")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage userLoginWithValidCredentials(String email, String pass) {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(pass);
        signInButton.click();
        return new HomePage(driver);
    }
}
