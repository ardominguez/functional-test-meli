package com.ardominguez.meli.pageobject;

import com.ardominguez.meli.basepageobject.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FilterProduct extends Base {

    @FindBy(how = How.CLASS_NAME, using ="breadcrumb__title")
    WebElement searchResult;
    @FindBy(how = How.CLASS_NAME, using ="ui-dropdown__link")
    WebElement dropdownIndicator;
    @FindBy(how = How.LINK_TEXT, using ="Mayor precio")
    WebElement descOption;

    public FilterProduct(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectProductDesc() throws InterruptedException {
        waitForVisivility(By.className("ui-dropdown__link"));
        dropdownIndicator.click();
        descOption.click();
    }

    public String getSearchName(){
        return searchResult.getText();
    }


}
