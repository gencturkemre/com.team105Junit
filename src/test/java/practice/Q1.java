package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {


    static WebDriver driver;

    // BeforeClass ile driver'i olusturun ve class icinde static yapin

    @BeforeClass

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize edin ve 10 sn bekletin

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    // http://www.google.com adresine gidin
    @Test
    public void test01() {
        driver.get("http://www.google.com");
        //  arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.className("gLFyf")).sendKeys("The Lord of the Rings" + Keys.ENTER);
        WebElement sonuc1 = driver.findElement(By.id("results-stats"));
        System.out.println("sonuc1.getText() = " + sonuc1.getText());
    }


    // arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin

    @Test
    public void test02() {


        driver.findElement(By.className("gLFyf")).sendKeys("Brave Heart" + Keys.ENTER);
        WebElement sonuc2 = driver.findElement(By.id("results-stats"));
        System.out.println("sonuc2.getText() = " + sonuc2.getText());
    }

    // arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03() {


        driver.findElement(By.className("gLFyf")).sendKeys("Harry Potter" + Keys.ENTER);
        WebElement sonuc3 = driver.findElement(By.id("results-stats"));
        System.out.println("sonuc3.getText() = " + sonuc3.getText());
    }
    // AfterClass ile kapatin

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

}


