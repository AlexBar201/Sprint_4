package com.example.app.tests;

import com.example.app.pages.HomePageQuestions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

import static com.example.app.pages.HomePageQuestions.*;

@RunWith(Parameterized.class)
public class HomePageQuestionTestParameterized {

    private WebDriver driver;

    //Создаем переменные в которых будут храниться параметры с соответствующим индексом из тестового набора
    @Parameterized.Parameter(0)
    public String question;
    @Parameterized.Parameter(1)
    public String textElem;

    //Создаём тестовые наборы данных в виде списка массивов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {_QUESTION_PAY, ANSWER_ELEM_PAY},
                {_QUESTION_MULTIPLE_SCOOTERS, ANSWER_ELEM_MULTIPLE_SCOOTERS},
                {_QUESTION_TIME_RENT, ANSWER_ELEM_TIME_RENT},
                {_QUESTION_TODAY_RENT, ANSWER_ELEM_TODAY_RENT},
                {_QUESTION_EXTEND_RENT, ANSWER_ELEM_EXTEND_RENT},
                {_QUESTION_CHARGING, ANSWER_ELEM_CHARGING},
                {_QUESTION_CANCELLATION, ANSWER_ELEM_CANCELLATION},
                {_QUESTION_BEYOND_THE_MKAD, ANSWER_ELEM_BEYOND_THE_MKAD}
        });
    }

    //Сам тест
    @Test
    public void testQuestionsDropdown() {
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageQuestions objQuestDrop = new HomePageQuestions(driver);
        objQuestDrop.checkDropdownTextOpensOnArrowClick(question, textElem);
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}