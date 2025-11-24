package org.example.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// Hooks pentru setup și teardown Selenium
public class Hooks {
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();             // Setup ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");   // Permite cross-origin
        // options.addArguments("--headless=new");          // Headless CI
        SharedDriver.driver = new ChromeDriver(options);    // Init driver
        SharedDriver.driver.manage().window().maximize();   // Maximizează fereastra
    }
    @After
    public void tearDown(){
        if(SharedDriver.driver != null) {
            SharedDriver.driver.quit();                     // Închide browser
        }
    }
}
