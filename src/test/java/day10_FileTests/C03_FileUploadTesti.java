package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void test01() {

        //  2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim

        //4. Yuklemek istediginiz dosyayi secelim.

        /*
        Bu görevi yapabilmek için chooseFİle butonuna basıldığında açılan bilgisayarımızdaki file dosyalarını
        click yapabilmemiz gerekir ancak selenium bilgisayarımızdaki dosyaları click yapamaz
        Bunun yerine  söyle bir çözüm üretilmiştir */

        // a-ChooseFile butonunu locate edin
        WebElement chooseFilebutonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        //b-Upload edilecek dosyanın dosya yolunu oluşturun
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\MerhabaJava.docx";

        //c-ChooseFile butonuna sentKeys ile dosya yolunu gönderin

        chooseFilebutonu.sendKeys(dosyaYolu);


        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();


        //6. “File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());


        ReusableMethods.bekle(5);
    }
}
