package tests;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class Day03_KiwiApp {

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
        //544,1691

        for (int i=0; i<3; i++){
            ReusableMethods.tiklamaMethodu(544,1691,1000);
        }
        Thread.sleep(1500);
        // Trip type,one way olarak secilir
        ReusableMethods.tiklamaMethodu(274,617,500);
        kiwiPage.oneWayButton.click();
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir 405,774
        ReusableMethods.tiklamaMethodu(405,774,750);
        ReusableMethods.tiklamaMethodu(1011,136,1000);
        //  ReusableMethods.screenScroolMethod(500,750,75,500,750,0);
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (!driver.isKeyboardShown()){
            kiwiPage.aramaKutusu.sendKeys("Istanbul");
        } else {
            driver.getKeyboard().pressKey("Istanbul");
        }
        Thread.sleep(1000);
        ReusableMethods.tiklamaMethodu(369,292,1000);
        kiwiPage.chooseButton.click();
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir 369,292
        kiwiPage.anywhereButton.click();
        driver.getKeyboard().pressKey("Varsova");
        Thread.sleep(1000);
        ReusableMethods.tiklamaMethodu(369,292,1000);
        kiwiPage.chooseButton.click();
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        kiwiPage.anyTimeButton.click();
        // 541,1341
        Thread.sleep(2000);
        //  ReusableMethods.screenScroolMethod(541,1341,800,548,482,750);
        ReusableMethods.tiklamaMethodu(672,1140,1000);
        kiwiPage.setDateButton.click();

        // search butonuna tiklanir
        kiwiPage.searchButton.click();
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        Thread.sleep(4000);
        ReusableMethods.tiklamaMethodu(259,259,750);
        ReusableMethods.tiklamaMethodu(409,584,750);
        kiwiPage.stopButton.click();
        kiwiPage.nanStopButton.click();
        Thread.sleep(2500);
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String fiyat= kiwiPage.priceBox.getText();
        driver.sendSMS("11111111111","Bu ucun icin fiyatiniz: "+fiyat);

    }
}