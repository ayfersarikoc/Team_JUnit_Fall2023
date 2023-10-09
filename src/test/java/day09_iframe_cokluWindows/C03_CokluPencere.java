package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_CokluPencere extends TestBase {
    @Test
    public void test01(){
        // amazon ana sayfaya gidip url'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        String expctdURLIcrkAmazon="amazon";
        String actualAmazonURL=driver.getCurrentUrl();
        Assert.assertTrue(actualAmazonURL.contains(expctdURLIcrkAmazon));
        String amazonWhd= driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        String expectedURLIcerik="wise";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURLIcerik));
        String wiseWhd= driver.getWindowHandle();


        // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        String expectedYoutubeIcerik="youtube";
        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedYoutubeIcerik));


        // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
        driver.switchTo().window(wiseWhd);
        String expectedTitleIcerik= "Wise";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonWhd);
        expectedTitleIcerik = "Amazon";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        wait(5);
    }
}
