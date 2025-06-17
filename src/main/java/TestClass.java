import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestClass {
    WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void getTitle1(){
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void getTitle2(){
        driver.get("https://www.ottplay.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void getTitle4(){
        driver.get("https://www.sonyliv.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void getTitle3(){
        driver.get("https://www.netflix.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
