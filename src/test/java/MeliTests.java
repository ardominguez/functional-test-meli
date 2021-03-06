import com.ardominguez.meli.basepageobject.Base;
import com.ardominguez.meli.pageobject.HomePage;
import com.ardominguez.meli.pageobject.Product;
import com.ardominguez.meli.pageobject.ProductDetailpage;
import com.ardominguez.meli.pageobject.ResultsProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;
import com.ardominguez.meli.util.Util;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

@Test
public class MeliTests {

    WebDriver driver;
    Base base;


    @BeforeMethod
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/ailenramayo/Downloads/chromedriver");
        driver = new ChromeDriver();
        base = new Base(driver);
        //driver = base.chromeWebDriverConnection();
        base.visit("https://www.mercadolibre.com.uy/");
    }
    @Parameters({"product-name"})
    @Test
    public void getProductPositionFour(String param)
    {

      System.out.println("First test");
      HomePage homePage;
      homePage = new HomePage(driver);
      ResultsProductsPage resultPage = homePage.searchProduct(param);
        WebDriverWait wait=new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".breadcrumb")));
      Product product = resultPage.getProduct(4);
      ProductDetailpage detailPage = resultPage.OpenProductPage(product);
      driver.close();

    }

    @Test(groups={"TestTwo"})
    void verifyProductSortedDesc() throws InterruptedException {
        System.out.println("Second test");
        HomePage homePage;
        homePage = new HomePage(driver);
        ResultsProductsPage resultPage = homePage.searchProduct("TV Lg");
        //FilterProduct filterProduct = new FilterProduct(driver);
        //Assert.assertEquals("Tv lg",filterProduct.getSearchName());
        resultPage.selectProductDesc();
        List<Product> products= resultPage.getResults();
        Assert.assertTrue(products.size()>0);
        for(int i=0;i<products.size()-1;i++){
            Product currentProduct = products.get(i);
            Product nextProduct = products.get(i+1);
            Assert.assertTrue(currentProduct.price >= nextProduct.price,currentProduct.name+" "+currentProduct.price+" "+nextProduct.name+" "+nextProduct.price);

        }
     driver.close();
    }

    @Test(groups = {"TestThree"})
    public void saveResultSearchCSVFile() throws Exception {
        System.out.println("Third test");
        HomePage home = new HomePage(driver);
        WebDriverWait wait=new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-logo")));

        assertEquals(home.getPageTitle(), "Mercado Libre Uruguay", "The page tittle isn't matching");
        ResultsProductsPage result = home.searchProduct("autos");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-results-header")));
        List<Product> items = result.getResultsForSave();
        Assert.assertTrue(items.size()>0,"There was no results in the search");
        Util.writeResultCSV("autos.csv",items);
        driver.close();
    }







}
