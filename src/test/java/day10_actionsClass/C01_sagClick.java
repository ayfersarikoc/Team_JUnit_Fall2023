package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_sagClick extends TestBase {
    /*2- https://the-internet.herokuapp.com/context_menu sitesine gidin
3- Cizili alan uzerinde sag click yapin
4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

     */
            @Test
            public void test01(){
            //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
                driver.get("https://the-internet.herokuapp.com/context_menu");
            //  3- Cizili alan uzerinde sag click yapin
                WebElement ciziliAlanElementi= driver.findElement(By.xpath("//*[@id='hot-spot']"));
                Actions actions=new Actions(driver);
                actions.contextClick(ciziliAlanElementi).perform();
            //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
                String expectedAlertYazisi="You selected a context menu";
                String actualAlerrtYazisi=driver.switchTo().alert().getText();
                Assert.assertEquals(expectedAlertYazisi,actualAlerrtYazisi);
            //5- Tamam diyerek alert’i kapatalim
                driver.switchTo().alert().accept();
            //    6- Elemental Selenium linkine tiklayalim
                String ilkSayfaWh=driver.getWindowHandle();
                WebElement elementelSeleniumLinkElement= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
                  elementelSeleniumLinkElement.click();
                  String ikinciSayfaWhd= "";
                Set<String> whdSeti=driver.getWindowHandles();

                for (String each:whdSeti){
                    if (!each.equals(ilkSayfaWh)){
                        ikinciSayfaWhd=each;
                    }
                }
            //    7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
                driver.switchTo().window(ikinciSayfaWhd);
                String actualIkinciSayfaYazi=driver.findElement(By.tagName("h1")).getText();

                String expectedYazi="Make sure your code lands" ;
                Assert.assertEquals(expectedYazi,actualIkinciSayfaYazi);

    }
}
