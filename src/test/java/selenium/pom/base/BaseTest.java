package selenium.pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.pom.util.GeneralUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static WebDriver driver;
    private Properties properties;

    public BaseTest() {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
            properties = new Properties();
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void browserSetup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("paraBank.baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));

    }
    public String getUsername(){
        return properties.getProperty("paraBank.username");

    }
    public String getPassword(){
        return properties.getProperty("paraBank.password");
    }



}
