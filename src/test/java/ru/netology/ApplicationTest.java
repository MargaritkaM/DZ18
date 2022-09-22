package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    private WebDriver driver;


    @BeforeAll
    static void setUpAll(){
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearsDown(){
        driver.quit();
        driver=null;
    }

    @Test
    void test(){
        driver.get ("http://localhost:9999/");
        List <WebElement> elements =driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Мусатова Маргарита");
        elements.get(1).sendKeys("+79169044591");
        driver.findElement(By.className("checkbox__text")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }
    @Test
    void test2(){
        driver.get ("http://localhost:9999/");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Мусатова Маргарита");
        driver.findElement(By.cssSelector("[type=tel]")).sendKeys("+79169044591");
        driver.findElement(By.cssSelector(".checkbox__text")).click();
        driver.findElement(By.cssSelector(".button__text")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }

//    @Test
//    void test3(){
//        driver.get ("http://localhost:9999/");
//        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Musatova Margarita");
////        driver.findElement(By.cssSelector("[type=tel]")).sendKeys("+79169044591");
////        driver.findElement(By.cssSelector(".checkbox__text")).click();
//        driver.findElement(By.cssSelector(".button__text")).click();
//        String text = driver.findElement(By.cssSelector("[.input_invalid]")).getText();
//        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
//
//    }

}
