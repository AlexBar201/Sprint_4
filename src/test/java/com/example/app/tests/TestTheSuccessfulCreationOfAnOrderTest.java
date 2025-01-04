package com.example.app.tests;

import com.example.app.pages.TestTheSuccessfulCreationOfAnOrder;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestTheSuccessfulCreationOfAnOrderTest {

    private WebDriver driver;

    //Начинаем писать тест
    @Test
    public void makingAnOrder(){

//Создали драйвер для браузера Chrome
        WebDriver driver = new ChromeDriver();
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
          WebDriver driver = new FirefoxDriver();*/

//Перешли на тестовый стенд
        driver.get("https://qa-scooter.praktikum-services.ru/");

//Создаем объект класса ToTestTheSuccessfulCreationOfAnOrder
        TestTheSuccessfulCreationOfAnOrder objSucFulCrOfAnOr = new TestTheSuccessfulCreationOfAnOrder(driver);

//Проверка создания заказа
//////Тестовый набор данных
        String name = "Александр";
        String surname = "Баранов";
        String address = "ул. Дмитрия Шмонина, д. 10, кв. 101";
        String number = "+79821484503";
//////Через кнопку FIRST_BUTTON_ORDER тест проходит успешно
        objSucFulCrOfAnOr.placingAnOrderViaTheFirstButtonOrder(name, surname, address, number);
//////Через кнопку SECOND_BUTTON_ORDER тест падает
        //driver.get("https://qa-scooter.praktikum-services.ru/");
        //objSucFulCrOfAnOr.placingAnOrderViaTheSecondButtonOrder(name, surname, address, number);
    }
    @After
    public void tearDown() {
        if (driver != null) { //Потому что не закрывает браузер, выдаёт ошибку, не могу понять, как исправить
            driver.quit();  // Закрытие браузера
        }
    }
}