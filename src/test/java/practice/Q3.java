package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q3 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
    */
    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement automationExeerciseBasligi = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        boolean baslikGorunurMu = automationExeerciseBasligi.isDisplayed();
        assertTrue(baslikGorunurMu);

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        // 5. Verify 'GET IN TOUCH' is visible
        String expContactUsPageBaslik = "GET IN TOUCH";
        WebElement actContactUsPageBaslik = driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        assertTrue(actContactUsPageBaslik.isDisplayed());

        // 6. Enter name, email, subject and message
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@name='name']"));


        Actions actions = new Actions(driver);
        actions.
                click(firstNameTextBox).
                sendKeys("ali").
                sendKeys(Keys.TAB).
                sendKeys("Ali@gamail.com").
                sendKeys(Keys.TAB).
                sendKeys("otomasyon").
                sendKeys(Keys.TAB).
                sendKeys("selam").
                perform();

        //7. Upload file

        WebElement dosyaSecButonu = driver.findElement(By.xpath("//input[@ name='upload_file']"));
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\MerhabaJava.docx";
        dosyaSecButonu.sendKeys(dosyaYolu);
        actions.sendKeys(Keys.PAGE_DOWN);


        // 8. Click 'Submit' button

        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //9. Click OK button

        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        assertTrue(success.isDisplayed());


        //11. Click 'Home' button and verify that landed to home page successfully

        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();

    }

}
