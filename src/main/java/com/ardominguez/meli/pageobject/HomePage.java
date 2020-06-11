package com.ardominguez.meli.pageobject;

import com.ardominguez.meli.basepageobject.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {

    By homePageLocator = By.className("nav-logo");
    SearchForm searchForm;


    //@FindBy(How = How.CSS)

    public HomePage(WebDriver driver) {
        super(driver);
        searchForm = new SearchForm(driver);

    }

    public boolean isHomePageDisplayed(){
        return isDisplayed(homePageLocator);
    }

    public ResultsProductsPage searchProduct(String product){

        isHomePageDisplayed();
        searchForm.search(product);
        return new ResultsProductsPage(driver);
    }

}
