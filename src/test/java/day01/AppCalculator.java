package day01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppCalculator {


    AndroidDriver<AndroidElement> driver;

    /*
       Android driver sadece android cihazlar icin olusturulmus bir driverdir.
       Bu yüzden Android cihazlarda daha kullanisli bir driverdır.
       Android cihazların kullanim farkliliklari daha zengin oldugu icin
       Android cihazlar icin gerekli olan hazir methodlari bu driver ile kullanarak cihazla ilgili islemleri yapabiliriz

       AndroidDriver<MobileElement> driver1;
       AppiumDriver<MobileElement> driver2

       Appium driver ise hem Ios hem de Android isletim sistemine sahip olan cihazlar icin tasarlanmistir.
       Bu driver ile birlikte iki farkli platformda islemlerimizi gerceklestirebiliriz

     */

    @Test
    public void test01() throws MalformedURLException {

        /*  kullanici gerekli kurulumlari yapar
            uygulamanin yuklendigini dogrular(isInstalled)
            uygulamanin acildigini dogrular
            100 un 5 katininin 500 oldugunu hesap makinasindan dogrular
         */

        // com.google.android.calculator  (APK info uygulamasından aldık)
        // com.google.android.calculator:id/op_mul

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        // eger kullanmis oldugumuz cihazin Android surumu 6 ya da 6  dan buyukse UiAutomator2 yi kullanmamiz gerekiyor,
        // Android surumu 6 dan kucukse UiAuotmator u kullanmamiz gerekiyor.

        capabilities.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\murat\\IdeaProjects\\Appium_T120\\apps\\Calculator.apk"); // absolute path

        // capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\murat\\IdeaProjects\\Appium_T120\\apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");

        driver = new AndroidDriver<>
                (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        }
}
