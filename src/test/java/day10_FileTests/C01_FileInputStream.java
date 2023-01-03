package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {
     /*
File testlerinde genellıkle dowloads'a indırılecek bır dosyanın ınırıldıgını test etmek veya
 bır dosyanın web'e yuklenebıldıgını test etmek ısterız
Ancak herkesın bılgısayarının ısmı , kullanıcı ısımlerı gıbı farklılıklar olacagınsan testler
tek bır bılgısayarda calısacak  gibi yazılmak zorunda kalırnır.
Bu karışıklıgın önüne geçebilmek için Java iki basit kod blogu sunmuş:
System.out.println(System.getProperty("user.dir"));  // o anca çalışan dosyanın (C01_FileInputStream) yolunu verir
System.out.println(System.getProperty("user.home")); //Kullanıcının temel path'ini verir.
     */

    @Test
    public void test01() throws FileNotFoundException {
        String dosyaYolu = "C:\\Users\\acer\\Desktop\\MerhabaJava.docx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        System.out.println(System.getProperty("user.dir"));
        // C:\Users\acer\com.Team105JUnit
       // o anca çalışan dosyanın (C01_FileInputStream) yolunu verir
        System.out.println(System.getProperty("user.home"));

        // C:\Users\acer
         //Kullanıcının temel path'ini verir.
        //Masaustune gitmek istersek
        //C:\Users\acer\com.Team105JUnit
        //Dowloads'a gitmek istersek
        //C:\Users\acer+/Downloads eklememız yeterlidir
       /* Kodlarımızın dınamık olması yani kısının bılgısayarındakı kullanıcı adı gibi detaylara takılmaması için
       file testlerinde kullanılacak dosya yolunu "user.home" temel path'ini çalıştıgı bılgısayardan alacak sekılde olustururuz
        */

        //  dosyaYolu = "C:\\Users\\acer\\Desktop\\MerhabaJava.docx";
        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Desktop\\MerhabaJava.docx";

    }
}
