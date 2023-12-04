package tests.day03;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    KiwiPage kiwiPage = new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPage.misafirButonu.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPage.misafirButonu.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir

        for (int i=0; i<3; i++){
            ReusableMethods.tiklamaMethodu(544,1691,1000);
        }
        Thread.sleep(1500);

        // Trip type,one way olarak secilir
        ReusableMethods.tiklamaMethodu(274,617,500);
        kiwiPage.oneWayButton.click();


        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        //  ReusableMethods.screenScroolMethod(500,750,75,500,750,0);
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    }
}