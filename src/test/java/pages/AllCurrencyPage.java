package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencyPage {

    public AllCurrencyPage() { PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this); }
                                                         // WebDriver casting yaptık

    @FindBy(xpath = "//*[@text='CURRENCY CONVERTER']")
    public WebElement currentText;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b1")
    public WebElement oneButton;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b0")
    public WebElement zeroButton;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement resultBox;
}
