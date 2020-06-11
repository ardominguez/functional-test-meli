package com.ardominguez.meli.pageobject;
import com.ardominguez.meli.basepageobject.Base;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class SearchForm extends Base {

    By searchButtonLocators = By.className("nav-icon-search");
    //By searchLocators = By.className("nav-search-input");
    @FindBy(how = How.CSS, using = ".nav-icon-search")
    WebElement searchButtonLocator;

    @FindBy(how = How.CSS, using = ".nav-search-input")
    WebElement searchInput;

    public SearchForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void search(String product){
      type(searchInput,product);

    }
}
