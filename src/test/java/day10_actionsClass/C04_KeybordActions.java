package day10_actionsClass;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_KeybordActions extends TestBase {
    /*2- https://www.amazon.com sayfasina gidelim
3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
4- aramanin gerceklestigini test edin
     */
    @Test
    public void test1(){
         //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusuElmnt= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Actions actions=new Actions(driver);
        actions.click(aramaKutusuElmnt)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
       // 4- aramanin gerceklestigini test edin
        String expectedIcerik = "Samsung A71";
        String actualSonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }

}
