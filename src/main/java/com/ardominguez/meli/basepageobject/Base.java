package com.ardominguez.meli.basepageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class Base {
     protected WebDriver driver;

     public Base(WebDriver driver){
         this.driver = driver;
     }

    public WebDriver chromeWebDriverConnection() {

        return driver;
    }

    public void visit(String url){
        driver.get(url);
     }

    public WebElement findElement(By locator) throws Exception {
        try
        {
            return driver.findElement(locator);
        }
        catch (Exception ex){
            ex.getMessage();
            throw ex;
        }
    }


    public List<WebElement> findElements(By locator) throws Exception{
             return driver.findElements(locator);
    }

    public String getText(WebElement element){
         return element.getText();
    }

    public void click(By locator){
          driver.findElement(locator).click();
    }
    public boolean isDisplayed(By locator){
         try{
             return driver.findElement(locator).isDisplayed();
         }
         catch(org.openqa.selenium.NoSuchElementException e)
        {
          return false;
        }

    }

    public void type(WebElement input, String text){
         input.sendKeys(text);
         input.sendKeys(Keys.ENTER);

    }

    public void waitForVisivility(By locator){
         WebDriverWait wait = new WebDriverWait(driver,20);
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void waitTime(Integer TimeOut){
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

    }


    public String getPageTitle() throws Exception {
        return driver.getTitle();

    }





}
