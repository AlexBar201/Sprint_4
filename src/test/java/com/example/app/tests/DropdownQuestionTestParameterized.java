package com.example.app.tests;

import com.example.app.pages.DropdownQuestions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
                {DropdownQuestions.ONE_ACCORDION, DropdownQuestions.PANEL_TEXT_ONE, DropdownQuestions.TEXT_ELEM_ONE},
                {DropdownQuestions.TWO_ACCORDION, DropdownQuestions.PANEL_TEXT_TWO, DropdownQuestions.TEXT_ELEM_TWO},
                {DropdownQuestions.THREE_ACCORDION, DropdownQuestions.PANEL_TEXT_THREE, DropdownQuestions.TEXT_ELEM_THREE},
                {DropdownQuestions.FOUR_ACCORDION, DropdownQuestions.PANEL_TEXT_FOUR, DropdownQuestions.TEXT_ELEM_FOUR},
                {DropdownQuestions.FIVE_ACCORDION, DropdownQuestions.PANEL_TEXT_FIVE, DropdownQuestions.TEXT_ELEM_FIVE},
                {DropdownQuestions.SIX_ACCORDION, DropdownQuestions.PANEL_TEXT_SIX, DropdownQuestions.TEXT_ELEM_SIX},
                {DropdownQuestions.SEVEN_ACCORDION, DropdownQuestions.PANEL_TEXT_SEVEN, DropdownQuestions.TEXT_ELEM_SEVEN},
                {DropdownQuestions.EIGHT_ACCORDION, DropdownQuestions.PANEL_TEXT_EIGHT, DropdownQuestions.TEXT_ELEM_EIGHT}
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