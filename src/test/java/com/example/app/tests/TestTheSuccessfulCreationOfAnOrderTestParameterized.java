package com.example.app.tests;

import com.example.app.pages.TestTheSuccessfulCreationOfAnOrder;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTheSuccessfulCreationOfAnOrderTestParameterized {

    private WebDriver driver;

    //Создаем переменные в которых будут храниться параметры с соответствующим индексом из тестового набора
    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public String surname;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public String number;

    //Создаём тестовые наборы данных в виде списка массивов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Александр", "Баранов", "ул. Дмитрия Шмонина, д. 10, кв. 101", "+79821484503"},
                {"Анатолий" , "Губка", "ул. Карла Маркса, д. 37, кв. 512", "+79821658506"}
        });
    }

//Сам тест
    //////В хроме два теста падают, в мозиле все 4 теста проходят успешно
    @Test
    public void testChromeAndMozillaCreateOrder(){
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
        driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        TestTheSuccessfulCreationOfAnOrder objTest = new TestTheSuccessfulCreationOfAnOrder(driver);
        objTest.placingAnOrderViaTheFirstButtonOrder(name, surname, address, number);
    }
    @Test
    public void testChromeAndMozillaCreateOrderTwo(){
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
        driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        TestTheSuccessfulCreationOfAnOrder objTest = new TestTheSuccessfulCreationOfAnOrder(driver);
        objTest.placingAnOrderViaTheSecondButtonOrder(name, surname, address, number);
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}