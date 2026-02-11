package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;

    public static void setup() {

        //  PERMANENT FIX
        // Always download matching ChromeDriver automatically
        WebDriverManager.chromedriver()
                .clearDriverCache()   // prevents old driver conflicts
                .setup();

        ChromeOptions options = new ChromeOptions();

        // Headless stable config
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // Avoid automation detection issues (Amazon sometimes blocks)
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");

        // NOTE:
        // start-maximized not needed in headless
        // options.addArguments("--start-maximized");

        // Real browser user-agent
        options.addArguments(
            "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
          + "AppleWebKit/537.36 (KHTML, like Gecko) "
          + "Chrome/120.0.0.0 Safari/537.36"
        );
        
        //  Reduce unwanted Selenium logs
        System.setProperty("webdriver.chrome.silentOutput", "true");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); // still ok

        driver.get("https://www.amazon.in");
    }

    public static void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}
