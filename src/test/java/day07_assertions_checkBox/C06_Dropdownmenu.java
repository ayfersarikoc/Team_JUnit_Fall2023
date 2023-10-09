package day07_assertions_checkBox;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_Dropdownmenu extends TestBase {
    @Test
   public void test01(){
        driver.get("https://www.amazon.com");
        // 1.adim : dropdown webelementini locate et
        WebElement dropDownElement=driver.findElement(By.xpath("//select[@title='Search in']"));

        // 2.adim locate ettigimiz webelementi parametre olarak yazip select objesi olustur
        Select select= new Select(dropDownElement);

        // 3.adim select objesi ile istenen islemi yap
        select.selectByValue("search-alias=automotive-intl-ship");
        wait(2);
        select.selectByIndex(7);
        wait(2);
        select.selectByVisibleText("Books");
        wait(2);


    }

}
