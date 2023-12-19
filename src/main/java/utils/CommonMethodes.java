package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CommonMethodes extends Initialize {
    public static void openBrowser(String URL) {
        driver.get(URL);
    }

    public static void navigateTo(String URL) {
        driver.navigate().to(URL);
    }


    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        System.out.println(by.toString() + " Elementi görüldü");

        return driver.findElement(by);
    }

    public void click(By by) {
        findElement(by).click();
        System.out.println(by.toString() + " Elementine tıklandı");
    }

    public void clear(By by) {
        findElement(by).clear();
        System.out.println(by.toString() + " Elementi temizlendi");
    }

    public void sendKeys(By by, String txt) {
        findElement(by).sendKeys(txt + Keys.ENTER);
        System.out.println(by.toString() + " Elementine " + txt + " karakterleri girildi");
    }

    public String getText(By by) {
        System.out.println(by.toString() + " Elementinden " + findElement(by).getText() + " text i alınndı");
        return findElement(by).getText();
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        System.out.println(by.toString() + " Elementi görüldü");
        return driver.findElements(by);
    }

    public void scrollDownUntilElementVisiable(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

        try {
            WebElement element = driver.findElement(by);
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } catch (Exception e) {
            System.out.println("Daha fazla content bulunmadı.");
        }
    }


    public void sleep(int timeSec) {
        try {
            Thread.sleep(timeSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
