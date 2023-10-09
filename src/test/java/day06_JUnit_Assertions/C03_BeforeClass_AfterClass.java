package day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {

    // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin
    /*
        Bize verilen gorevde
        olusturulacak farkli test method'lari
        ayni web sayfasinda oluyorsa
        her test method'unda yeniden driver olusturup, sonunda kapatmak yerine
        Tum @Test method'larindan once 1 kere driver olusturup
        tum @Test method'larini calistirip
        en son driver'i kapatmak daha mantikli olur
        //******************************************
        @BeforeClass ve @AfterClass notasyonlari kullanildiginda
        DIKKAT etmemiz gereken konu
        >>>>>>>bu notasyonlari kullanan method'larin
        static olarak<<<<<<<<<<< isaretlenmesinin ZORUNLU olmasidir
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
             driver=new ChromeDriver();
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
             driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
// 1- Title'in Amazon icerdigini test edin
    @Test
    public void amazonTest(){
    String expectedTitleIcerik="Amazon";
    String actualTitle= driver.getTitle();
    if(actualTitle.contains(expectedTitleIcerik)){
        System.out.println("Title testi Passed");
    }else {
        System.out.println("Title testi Failed");
    }
    }

    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    @Test
    public void nutellaTest(){
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-" +
                "top-small'])[1]"));
        String expectedSonucIcerik="Nutella";
        String actualSonucYazisi=sonucYaziElementi.getText();

        if (actualSonucYazisi.contains(expectedSonucIcerik)) {

            System.out.println("Nutella Test PASSED");
        }else {
            System.out.println("Nutella Test FAILED");
        }

}
    // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin
        @Test
        public void javaTest(){
            WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
           aramaKutusu.clear();
            aramaKutusu.sendKeys("Java"+ Keys.ENTER);

            WebElement sonucYaziElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-" +
                    "top-small'])[1]"));
            String expectedSonucIcerik="Java";
            String actualSonucYazisi=sonucYaziElementi.getText();

            if (actualSonucYazisi.contains(expectedSonucIcerik)) {

                System.out.println("Java Test PASSED");
            }else {
                System.out.println("Java Test FAILED");
            }

    }

}
