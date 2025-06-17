import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestClass {
    WebDriver driver;

    @BeforeMethod
    public void launchBrowser() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

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
