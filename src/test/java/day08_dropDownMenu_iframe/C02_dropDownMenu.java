package day08_dropDownMenu_iframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C02_dropDownMenu extends TestBase_BeforeClass {

    WebElement kategoriDropDownElement;
    Select select;


    @Before
        public void amazonaGidis(){

    driver.get("https://www.amazon.com/");
    kategoriDropDownElement=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
    select=new Select(kategoriDropDownElement);

}
    @Test
    public void dropdownTesti(){


        //- Test 1
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        List<WebElement> optionList=select.getOptions();
        int expectedkategorisayisi=45;
        int actualKategoriSayisi= optionList.size();
        Assert.assertEquals(expectedkategorisayisi,actualKategoriSayisi);

}
    @Test
    public void javaAramaTesti() {
        //-Test 2
        //  1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");
        //  2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu= driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[1]"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        //  3. Bulunan sonuc sayisini yazdirin
        WebElement aramaSonucElement=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(aramaSonucElement.getText());
        //  4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        String actualSonucYazisi=aramaSonucElement.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}