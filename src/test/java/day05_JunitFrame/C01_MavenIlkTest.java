package day05_JunitFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
               /*
            13.satiri yazmamiz mecburi degildir
            Selenium 4.8 versiyonundan itibaren kendi WebDriver'ini olusturmustur
            biz 13.satirdaki gibi disardan bir WebDriver tanimlamazsak
            Selenium otomatik olarak kendi WebDriver'ini devreye sokar
         */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        //2- arama kutusunu locate edelim
       WebElement searchbox =driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
       searchbox.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement resulTextElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(resulTextElement.getText());
        //5- Ilk urunu tiklayalim //div[@id='a-page']
        driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal'][1]")).click();
         // Bir onceki sayfaya donup sayfadaki  tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> baslikElementleri= driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));

                for (int i=0; i< baslikElementleri.size();i++){
            System.out.println(i+"_"+baslikElementleri.get(i).getText());

        }


        ReusableMethods.wait(5);
                driver.close();




    }
}
