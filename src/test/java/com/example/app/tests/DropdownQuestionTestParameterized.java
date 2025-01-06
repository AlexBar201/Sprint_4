package com.example.app.tests;

import com.example.app.pages.DropdownQuestions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DropdownQuestionTestParameterized {

    private WebDriver driver;

    //Создаем переменные в которых будут храниться параметры с соответствующим индексом из тестового набора
    @Parameterized.Parameter(0)
    public By accordion;
    @Parameterized.Parameter(1)
    public By panelText;
    @Parameterized.Parameter(2)
    public String textElem;

    //Создаём тестовые наборы данных в виде списка массивов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {DropdownQuestions.QUESTION_PAY, DropdownQuestions.PANEL_ANSWER_PAY, DropdownQuestions.ANSWER_ELEM_PAY},
                {DropdownQuestions.QUESTION_MULTIPLE_SCOOTERS, DropdownQuestions.PANEL_ANSWER_MULTIPLE_SCOOTERS, DropdownQuestions.ANSWER_ELEM_MULTIPLE_SCOOTERS},
                {DropdownQuestions.QUESTION_TIME_RENT, DropdownQuestions.PANEL_ANSWER_TIME_RENT, DropdownQuestions.ANSWER_ELEM_TIME_RENT},
                {DropdownQuestions.QUESTION_TODAY_RENT, DropdownQuestions.PANEL_ANSWER_TODAY_RENT, DropdownQuestions.ANSWER_ELEM_TODAY_RENT},
                {DropdownQuestions.QUESTION_EXTEND_RENT, DropdownQuestions.PANEL_ANSWER_EXTEND_RENT, DropdownQuestions.ANSWER_ELEM_EXTEND_RENT},
                {DropdownQuestions.QUESTION_CHARGING, DropdownQuestions.PANEL_ANSWER_CHARGING, DropdownQuestions.ANSWER_ELEM_CHARGING},
                {DropdownQuestions.QUESTION_ORDER_CANCELLATION, DropdownQuestions.PANEL_ANSWER_CANCELLATION, DropdownQuestions.ANSWER_ELEM_CANCELLATION},
                {DropdownQuestions.QUESTION_BEYOND_THE_MKAD, DropdownQuestions.PANEL_ANSWER_BEYOND_THE_MKAD, DropdownQuestions.ANSWER_ELEM_BEYOND_THE_MKAD}
        });
    }

    //Сам тест
    @Test
    public void testQuestionsDropdown() {
        /*System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\Firefox\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        DropdownQuestions objQuestDrop = new DropdownQuestions(driver);

        objQuestDrop.scrollQuestionsDropdown();
        objQuestDrop.checkDropdownTextOpensOnArrowClick(accordion, panelText, textElem);
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}