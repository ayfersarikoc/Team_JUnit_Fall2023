package day08_dropDownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01_dropdownMenu extends TestBase {
    @Test
    public void dropdownTest(){
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown ");
        //dropdown olmasi icin once bakicaz:
        //select tagiyla mi acilmis,
        //selectin i actiginda option menusu var mi , varsa her option da value var mi?
        //>>>>>>>>>>>eger dropdowndan eminsek o alanin webelementini alicaz(locate edicez)
        WebElement dropDownElement= driver.findElement(By.xpath("//select[@id='dropdown']"));
        //>>>>>>>>>simdi select objesi olusturucaz(dropdowwebnelementini parantez icine yazicaz)
        Select select=new Select(dropDownElement);
        wait(2);

        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");//bununla o degerin icine girer sadece .ondan sonra yazdirma islemi icin bir sonraki satir
        System.out.println(select.getFirstSelectedOption().getText());
        wait(2);

        //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        select.getFirstSelectedOption().getText();
        wait(2);

        //  4.Tüm dropdown değerleri(value) yazdırın
        System.out.println("===Tum opsiyonlar===");

        List<WebElement> optionList=select.getOptions();
        for (WebElement each:optionList //bizim oglan webelement each , nerden alacak degerleri..optionlistten
             ) {
            System.out.println(each.getText());// bizim oglanin degerleriniget,text ile alip sout ile tek tek yazdiricaz
        }

        //  5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedboyut=4;
        int actualboyut=optionList.size();

        Assert.assertEquals("dropdown menu boyutu 4 degil",expectedboyut,actualboyut);
    }

}
