package com.ardominguez.meli.pageobject;

import com.ardominguez.meli.basepageobject.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsProductsPage extends Base {

    @FindBy(how = How.CLASS_NAME, using ="breadcrumb__title")
    WebElement searchResult;
    @FindBy(how = How.CLASS_NAME, using ="ui-dropdown__link")
    WebElement dropdownIndicator;
    @FindBy(how = How.LINK_TEXT, using ="Mayor precio")
    WebElement descOption;
    @FindBy(how = How.CSS, using = ".results-item")
    List<WebElement> results;
    WebElement resultList;

    public ProductDetailpage OpenProductPage(Product product){
        product.refProduct.click();
        return new ProductDetailpage(driver);
    }

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

    public void selectProductDesc() throws InterruptedException {
        waitForVisivility(By.className("ui-dropdown__link"));
        dropdownIndicator.click();
        descOption.click();
    }

    public ArrayList<Product> getResultsForSave() {
        ArrayList<Product> results=new ArrayList<Product>();
        List<WebElement> list = resultList.findElements(By.cssSelector("li.results-item"));

        if(list.size()> 0) {

            for(WebElement item: list ) {

                WebElement link = item.findElement(By.cssSelector("a"));
                String linkItem = link.getAttribute("href");
                WebElement name = item.findElement(By.cssSelector("span.main-title"));
                String nameItem = name.getText();

                Product result = new Product();
                result.name = nameItem;
                result.link = linkItem;
                results.add(result);

            }
        }

        return results;

    }

}
