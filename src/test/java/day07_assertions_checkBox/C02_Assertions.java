package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Assertions {
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun
    //   ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
            public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        ReusableMethods.wait(1);
         driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[14]")).click();
         ReusableMethods.wait(5);
    }
  @AfterClass
    public static void teardown() {
        driver.close();
    }
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }
    @Test
    // 2- imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
            public void youTubeTest(){


WebElement imageYotubeElement= driver.findElement(By.xpath("(//a[@class='yt-simple-endpoint style-scope ytd-topbar-logo-renderer'])[1]"));
Assert.assertTrue(imageYotubeElement.isDisplayed());
    }
    @Test
   //3_  Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    public void searchBoxTest(){
        WebElement searchBoxElement=driver.findElement(By.xpath("//div[@class='ytd-searchbox-spt']"));
        Assert.assertTrue(searchBoxElement.isEnabled());
    }
    @Test
    // 4-wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
            public void wrongTitleTest(){

    String unexpectedtitle= "youtube";
    String actualtitle= driver.getTitle();
    Assert.assertNotEquals(unexpectedtitle,actualtitle);
   // Assert.assertFalse(unexpectedtitle.equals(actualtitle));
    }
}
