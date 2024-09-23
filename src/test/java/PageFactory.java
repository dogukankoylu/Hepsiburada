import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class PageFactory {
    public PageFactory(WebDriver driver) {
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver,this);
    }
    private WebDriver driver;
    public void goTo(String adress){
        driver.get(adress);
    }
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cerezler;
    @FindBy(xpath = "(//div[@class='initialComponent-hk7c_9tvgJ8ELzRuGJwC'])[1]")
    private WebElement araClick;
    @FindBy(className = "searchBarContent-UfviL0lUukyp5yKZTi4k")
    private WebElement ara;
    @FindBy(xpath = "//b[@class='searchResultSummaryBar-AVnHBWRNB0_veFy34hco']")
    private WebElement dogrulama;
    @FindBy(xpath = "//div[contains(text(),'Daniel Klein')]")
    private WebElement scrollMarka;
    @FindBy(xpath = "//input[@value='Erkek']")
    private WebElement scrollCinsiyet;
    @FindBy(xpath = "(//b[@class='searchResultSummaryBar-AVnHBWRNB0_veFy34hco'])[1]")
    private WebElement sonucDogrulama;
    @FindBy(xpath = "//a[@title='Daniel Klein DKE.1.10657 Exclusive Tüm Fonksiyonlar Aktif Silikon Kordonlu Farklı Renk Seçenekli Çelik Kaplama Erkek Kol Saati']//h3[@type='comfort']")
    private WebElement urun;
    @FindBy(xpath = "//div[@class='storefront-app desktop-app']")
    private WebElement urunDogrula;
    @FindBy(xpath = "//input[@value='Beyaz']")
    private WebElement beyaz;
    @FindBy(xpath = "//h3[contains(text(),'Nıke Full Force Unısex Ayakkabı Fb1362-101')]")
    private WebElement ayakkabi;

    public void cookies(){
        cerezler.click();
    }
    public void searchClick(){
        araClick.click();
    }
    public void search(String urun){
        ara.sendKeys(urun + Keys.ENTER);
    }
    public void assertion(){
        String xpath = dogrulama.getText();
        Assert.assertTrue(xpath.contains("10000+"));
    }
    public void scrollBrand(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",scrollMarka);
        scrollMarka.click();
        driver.navigate().refresh();
    }
    public void scrollGender(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",scrollCinsiyet);
        scrollCinsiyet.click();
        driver.navigate().refresh();
    }
    public void assertionResult(String sonuc){
        String xpath = sonucDogrulama.getText();
        Assert.assertTrue(xpath.contains(sonuc));
    }
    public void product(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",urun);
        urun.click();
    }
    public void productAssert(){
        Assert.assertTrue(urunDogrula.isDisplayed());

    }
    public void white(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",beyaz);
        beyaz.click();
        driver.navigate().refresh();
    }
    public void shoe(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",ayakkabi);
        ayakkabi.click();
    }




}
