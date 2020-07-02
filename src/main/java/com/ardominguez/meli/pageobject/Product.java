package com.ardominguez.meli.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product{
    public String name;
    public Double price;
    public String link;
    public WebElement refProduct;

    public Product(){
    }

    public Product(WebElement element){
     refProduct = element;
     name = element.findElement(By.className("main-title")).getText();
     WebElement linkElement = element.findElement(By.cssSelector("a"));
     link = linkElement.getAttribute("href");
     String currency = element.findElement(By.className("price__symbol")).getText();
     String priceText = element.findElement(By.className("price__fraction")).getText();
     priceText=priceText.replace(".","");
     if(currency.equals("$")){
         price = Double.valueOf(priceText);
     }
     else{
         price = Double.valueOf(priceText)*42.86;
     }


    }

    public Double getProductSortedPrice() {
        return price;
    }
}
