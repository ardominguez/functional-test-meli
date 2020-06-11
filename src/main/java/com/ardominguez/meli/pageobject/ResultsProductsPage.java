package com.ardominguez.meli.pageobject;

import com.ardominguez.meli.basepageobject.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsProductsPage extends Base {

    @FindBy(how = How.CSS, using = ".results-item")
    List<WebElement> results;

    public ResultsProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public Product getProduct(Integer index){
        WebElement element = results.get(index);
     return new Product(element);
    }

    public List<Product> getResults(){
        ArrayList<Product> products = new ArrayList<Product>();
        for(WebElement result: results){
            Product product = new Product(result);
            products.add(product);
        }
        return products;
    }

}
