package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_KontrolsuzCokluWindow extends TestBase {

    @Test
    public void cokluPencereTesti(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWhd= driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedYazi = "Opening a new window";
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        String actualYazi= yaziElementi.getText();
       Assert.assertEquals(expectedYazi,actualYazi);
        wait(2);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        wait(2);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
            Bir linke tikladigimizda
            biz newWindow() kullanmadigimiz halde yeni sayfa aciliyorsa
            driver eski sayfada kalir
            yeni sayfada islem yapabilmek icin
            bizim driver'i yeni sayfaya gecirmemiz gerekir.
         */
        Set<String> whdSeti= driver.getWindowHandles();
        System.out.println("ilk sayfanin whd : "+ilkSayfaWhd);
        System.out.println("window handle seti: "+ whdSeti);
        String ikinciSayfaWhd="";

        for (String each:
             whdSeti) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWhd);
        String expectedYeniTitle= "New Window";
        String actualTitle1=driver.getTitle();
        Assert.assertEquals(expectedYeniTitle,actualTitle1);
        // artik 2.sayfanin whd'ini bildigimiz icin, ikinci sayfaya gecis yapabiliriz
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expected2Yazi = "New Window";
        WebElement yazi2Elementi = driver.findElement(By.tagName("h3"));
        String actual2Yazi= yazi2Elementi.getText();
        Assert.assertEquals(expected2Yazi,actual2Yazi);
        //● Bir önceki pencereye geri döndükten sonra
        //  sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWhd);
        String expected3Title = "The Internet";
        String actual3Title = driver.getTitle();
        Assert.assertEquals(expected3Title,actual3Title);
    }
}
