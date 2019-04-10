import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static junit.framework.Assert.assertEquals;


public class Test1 {
    public ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test-1");
    }
    @Test
    public void test1() {
        /*Заходим на сайт и выбираем нужную кнопку для перехода*/
        driver.get("https://www.wrike.com");
        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-pro\"]/form")));

        /*Создание нужной почты по маске*/
        Random ran = new Random();
        int top = 7;
        char data = ' ';
        java.lang.String dat = "";

        for (int i = 0; i <= top; i++) {
            data = (char) (ran.nextInt(25) + 97);
            dat = data + dat;
        }

        String email = dat + "wpt@wriketask.qaa";
        /*System.out.println(email);*/
        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[2]/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]")));

        /*Выбор произвольной кнопки на первый вопрос*/
        int max = 2;
        int min = 1;
        int diff = max-min;
        Random num = new Random();
        int i = num.nextInt(diff + 1);
        i += min;

        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[" + i + "]/button")).click();
        /* Выбор произвольной кнопки на второй вопрос*/
        int max1 = 5;
        int min1 = 1;
        int diff1 = max1-min1;
        Random num1 = new Random();
        int r = num1.nextInt(diff1 + 1);
        r += min1;

        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[" + r + "]/button")).click();
        /* Выбор произвольной кнопки на третий вопрос*/
        int max2 = 3;
        int min2 = 1;
        int diff2 = max2-min2;
        Random num2 = new Random();
        int r1 = num2.nextInt(diff2 + 1);
        r1 += min2;

        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[" + r1 +"]/button")).click();
        /*Ждем пока кнопка станет активной и нажимаем на нее*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")));
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")).click();
        /*Ждем пока пропадет форма после нажатия на кнопку*/
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button"),"Submit result"));
        /*System.out.println("Test-1 close");*/

        /*Проверяем нажалась ли кнопка(совершено ли по ней действие)*/
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")).click();
        if( driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")).isEnabled()){
            System.out.println("Element is Enable");
        }else{
            System.out.println("Element is Disabled");
        }
        /*System.out.println("Test-1 close");*/
        /*Проверка ссылки на твиттер внизу экрана*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]")));
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
        elem.click();
        driver.getCurrentUrl().equals("https://twitter.com/wrike");
        /*Проверка изображения на значке твиттера*/
        List<WebElement> images = driver.findElements(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]/a/svg"));
        assertEquals(images.size(), 0);
        /*System.out.println("Test-2 open");*/


    }


    @After
    public void close() {
        System.out.println("Test-2 close");
        /*driver.quit();*/
    }

}
