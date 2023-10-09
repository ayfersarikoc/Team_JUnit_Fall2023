package day08_dropDownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_BasicAuthentication extends TestBase {
    @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //  Username     : admin
        //  password      : admin
        //
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement tebrikYaziElement= driver.findElement(By.tagName("p"));
        String actualTebrikYazisi=tebrikYaziElement.getText();
        String expectedIcerik="Congratulations";
        Assert.assertTrue(actualTebrikYazisi.contains(expectedIcerik));
        wait(5);

    }

}
