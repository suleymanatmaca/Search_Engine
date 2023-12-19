package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.pojo.AllContents;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static java.time.Duration.ofSeconds;

public class Initialize {
    public enum WebBrowsers {
        CHROME, CHROME_WINDOWS, CHROME_ON_DOCKER
    }

    public static WebDriver driver;
    static final String HOST_URL = "http://localhost:4444/wd/hub";
    protected static WebDriverWait wait;

    protected static CommonMethodes methodes = new CommonMethodes();
    protected static AllContents allContents = new AllContents();
    protected static DataHelper dataHelper = new DataHelper();
    File T = new File("src/test/resources/");
    File Tstdt = new File(T, "test-data.properties");

    public String getTestDataPF(String KeyName) {
        Properties prop = null;
        InputStream IP = null;
        try {
            IP = new FileInputStream(Tstdt.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(IP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String Val = prop.getProperty(KeyName);
        return Val;

    }

    @BeforeClass
    public void setUpClass() throws Exception {
        driver = initializeDriver();
    }


    @AfterClass
    public void tearDownClass() {
        System.out.flush();
        driver.quit();
    }

    public WebDriver initializeDriver() {
        ChromeOptions options = new ChromeOptions();

        WebBrowsers browserType = WebBrowsers.valueOf(getTestDataPF("browser"));
        switch (browserType) {
            case CHROME:
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-allow-origins=*");

                File f = new File("/usr/bin/");
                File ChromeDriver = new File(f, "chromedriver");

                System.setProperty("webdriver.chrome.driver", ChromeDriver.getAbsolutePath());

                driver = new ChromeDriver(options);
                System.out.println("*******************");
                System.out.println("Chrome Browser başlatıldı");

                driver.manage().deleteAllCookies();
                System.out.println("Tüm çerezler silindi");
                driver.manage().window().maximize();
                System.out.println("Sayfa tam ekran yapıldı");

                driver.manage().timeouts().implicitlyWait(ofSeconds(Integer.parseInt(getTestDataPF("ImplicitWait"))));
                wait = new WebDriverWait(driver, ofSeconds(Integer.parseInt(getTestDataPF("ExplicitWait"))));

                return driver;

            case CHROME_WINDOWS:
                File file = new File("src/test/driver/");
                File windowsChromeDriver = new File(file, "chromedriver.exe");
                //options.addArguments("--headless=new");
                options.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", windowsChromeDriver.getAbsolutePath());
                driver = new ChromeDriver(options);

                driver.manage().window().maximize();
                System.out.println("Sayfa tam ekran yapıldı");

                driver.manage().timeouts().implicitlyWait(ofSeconds(Integer.parseInt(getTestDataPF("ImplicitWait"))));
                wait = new WebDriverWait(driver, ofSeconds(Integer.parseInt(getTestDataPF("ExplicitWait"))));

                return driver;

            case CHROME_ON_DOCKER:
                ChromeOptions opt = new ChromeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(HOST_URL), opt);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                driver.manage().timeouts().implicitlyWait(ofSeconds(Integer.parseInt(getTestDataPF("ImplicitWait"))));
                wait = new WebDriverWait(driver, ofSeconds(Integer.parseInt(getTestDataPF("ExplicitWait"))));

                return driver;

            default:
                return null;
        }
    }
}