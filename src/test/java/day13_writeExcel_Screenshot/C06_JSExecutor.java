package day13_writeExcel_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecutor extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement sellink=driver.findElement(By.xpath("//a[text()='Gift Card']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("argument[0].click();",sellink);
        jse.executeScript("alert('bitti')");
    }
}
