import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

public class TestClass {
    static WebDriver driver;
    static BaseTest baseTest;
    static PageFactory pageFactory;

    @BeforeEach
    public void start(){
        baseTest = new BaseTest();
        driver = baseTest.startDriver();
        pageFactory = new PageFactory(driver);
    }
    @ParameterizedTest
    @CsvSource({"nike,13","saat,36"})
    public void Test(String product, String result) throws InterruptedException {
        pageFactory.goTo("https://www.hepsiburada.com/");
        Thread.sleep(3000);
        pageFactory.cookies();
        Thread.sleep(3000);
        pageFactory.searchClick();
        pageFactory.search(product);
        if (product.equals("saat")) {
            pageFactory.assertion();
            pageFactory.scrollBrand();
            pageFactory.scrollGender();
            pageFactory.assertionResult(result);
            pageFactory.product();
        }
        else if (product.equals("nike")) {
            pageFactory.white();
            pageFactory.shoe();
        }
        pageFactory.productAssert();
    }
        @AfterEach
        public void finish(){
            baseTest.closeDriver();
        }
}