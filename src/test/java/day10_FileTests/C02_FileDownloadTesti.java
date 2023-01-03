package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.annotation.Tainted;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {
    @Test
    public void test01() {

        //  1. Tests packagenin altina bir class oluşturalim : C04_FileDownload

        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");


        //3. Facebookd.png dosyasını indirelim

        driver.findElement(By.xpath("//a[text()='Facebookd.png']")).click();

        ReusableMethods.bekle(3);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        //test için öncelikle dosyanın indirildiğinde dosyaYolu ne olacak bunu oluşturmalıyız

        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\Facebookd.png";

        /*
Bir dosyanın bılgısayarımızda var oldugunu(exist) test etmek için Java'daki Files class'ından yardım alacağız
 */

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test

    public void test02() {
        // Masaüstünde MerhabaJava.docx dosyasının olduğunu test edin

        // dinamik dosya yolu oluşturalım
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
