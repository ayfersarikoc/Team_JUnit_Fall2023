package day08_dropDownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSAlerts extends TestBase {

    @Test
    public void  test01(){
        //youtube ana sayfasina gidin
        driver.get("https://www.youtube.com");

        //cookies kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[14]")).click();
        wait(7);
    }
    @Test
    public void jsAlertTest(){
        //2.Test
        //  //● https://the-internet.herokuapp.com/javascript_alert adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        wait(2);
        //1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        wait(2);

        //Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedYazi="I am a JS Alert";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        wait(2);
        //OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        wait(2);

    }
    @Test
    public void cancelTest(){

    //● https://the-internet.herokuapp.com/javascript_alert adresine gidin.
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    //2.alert e tiklayin
        WebElement ikincialertElement= driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        ikincialertElement.click();
    //Cancel'a basip , cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expextedsonucYazisi="You clicked: Cancel";
        WebElement sonucYaziElement=driver.findElement(By.xpath("//p[@id='result']"));
        String acualSonucYazisi= sonucYaziElement.getText();
        Assert.assertEquals(expextedsonucYazisi,acualSonucYazisi);




    }
    //4.Test
    //● https://the-internet.herokuapp.com/javascript_alert adresine gidin.
    //3.alert e tiklayin
    // Cikan prompt ekranina "Abdullah" yazdiralim
    //OK tusuna basarak slert;i kapatalim
    // Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void promptTest(){
        //● https://the-internet.herokuapp.com/javascript_alert adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3.alert e tiklayin
        WebElement promptEkranElement= driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        promptEkranElement.click();
        // Cikan prompt ekranina "Abdullah" yazdiralim(once alerte gecis yapmak lazim.onun icin switch to kullanicaz)
        driver.switchTo().alert().sendKeys("Abdullah");
        //OK tusuna basarak alert;i kapatalim
        driver.switchTo().alert().accept();
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//p[@id='result']"));
        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedIcerikYazisi="Abdullah";
        String actualSonucYazisi=sonucYaziElementi.getText();



    }




}
