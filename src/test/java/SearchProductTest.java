import com.ardominguez.meli.basepageobject.Base;
import com.ardominguez.meli.pageobject.FilterProduct;
import com.ardominguez.meli.pageobject.HomePage;
import com.ardominguez.meli.pageobject.Product;
import com.ardominguez.meli.pageobject.ResultsProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

@Test
public class SearchProductTest {

    WebDriver driver;
    Base base;

    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/ailenramayo/Downloads/chromedriver");
        driver = new ChromeDriver();
        base = new Base(driver);
        //driver = base.chromeWebDriverConnection();
        base.visit("https://www.mercadolibre.com.uy/");
    }
    @Test
    void Test()
    {
      HomePage homePage;
      homePage = new HomePage(driver);
      ResultsProductsPage resultPage = homePage.searchProduct("TV Lg");
      Product product = resultPage.getProduct(4);
      //Assert.assertEquals(product.name,"");

      //WebElement searchElement = driver.findElement(By.className("nav-search-input"));
      //searchElement.sendKeys("tv lg 4k");
      //WebElement searchButton = driver.findElement(By.className("nav-icon-search"));
      //searchButton.click();
      //WebElement container = driver.findElement(By.className("results-item highlighted article stack product "));
      //WebElement resultsProduct = driver.findElement(By.id("searchResults"));

     // List<WebElement> results = driver.findElements(By.className("results-item"));
      //results.get(3).findElement(By.cssSelector("li a.figure")).click();

    }

    @Test
    void verifyProductsSortedDesc() throws InterruptedException {

        HomePage homePage;
        homePage = new HomePage(driver);
        ResultsProductsPage resultPage = homePage.searchProduct("TV Lg");
        FilterProduct filterProduct = new FilterProduct(driver);

        //Assert.assertEquals("Tv lg",filterProduct.getSearchName());

        filterProduct.selectProductDesc();

        List<Product> products= resultPage.getResults();
        Assert.assertTrue(products.size()>0);
        for(int i=0;i<products.size()-1;i++){
            Product currentProduct = products.get(i);
            Product nextProduct = products.get(i+1);
            Assert.assertTrue(currentProduct.price >= nextProduct.price,currentProduct.name+" "+currentProduct.price+" "+nextProduct.name+" "+nextProduct.price);

        }

    }







}
