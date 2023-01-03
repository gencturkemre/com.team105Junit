package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q2 extends TestBase {
    //              ..Exercise2...
//  http://www.bestbuy.com 'a gidin,

//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin

//  Ayrica Relative Locator kullanarak;

//      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin

//  Ayrica Relative Locator kullanarak;

//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin


    //  http://www.bestbuy.com 'a gidin,
    @Before
    public void beforeTest() {

        driver.get("http://www.bestbuy.com");
    }

    //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    @Test
    public void titleTest() {
        String expectedTitle = "Best";
        String actTitle = driver.getTitle();
        //System.out.println(actTitle);
        //boolean iceriyorMu=actTitle.contains(expectedTitle); farklı yol
        assertTrue(actTitle.contains(expectedTitle));

    }

    //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
    //       Ayrica Relative Locator kullanarak;
    @Test
    public void logoTest() {
        WebElement helloHeading = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement bestBuyLogo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        assertTrue(bestBuyLogo.isDisplayed());

    }

    //     Ayrica Relative Locator kullanarak;

    //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
    @Test
    public void mexicoLinkTest() {
        WebElement usFlag = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoFlag = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usFlag));
       assertTrue(mexicoFlag.isDisplayed());  //satır başındaki Assert i silerek import ettik.... assert kısaldı :)

//boolean goruntuleniyorMu=mexicoFlag.isDisplayed();  2.yol
//Assert.assertTrue(goruntuleniyorMu);                 2.yol

    }
}
