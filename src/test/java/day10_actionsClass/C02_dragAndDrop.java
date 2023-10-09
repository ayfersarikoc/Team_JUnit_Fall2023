package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {

    /*1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

     */
   @Test
   public void test01() {
       //*1- https://demoqa.com/droppable adresine gidelim
       driver.get("https://demoqa.com/droppable");
      // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
       WebElement suruklenecekElement= driver.findElement(By.xpath("//*[text()='Drag me']"));
       WebElement suruklenecekHedefAlan= driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
       Actions actions=new Actions(driver);
       actions.dragAndDrop(suruklenecekElement,suruklenecekHedefAlan).perform();
       wait(2);
       // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
       String expectedYazi="Dropped!";
       WebElement yaziElement= driver.findElement(By.xpath("//*[text()='Dropped!']"));
       String actualYazi= yaziElement.getText();

       Assert.assertEquals(expectedYazi,actualYazi);


   }

}
