package com.example.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Вопросы о важном !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class DropdownQuestions {

    private WebDriver driver;

    //Локаторы Accordion элемента с вопросом для метода clickDropdownArrow
    public static final By ONE_ACCORDION = By.id("accordion__heading-0");//Accordion "Сколько это стоит? И как оплатить?"
    public static final By TWO_ACCORDION = By.id("accordion__heading-1");//Accordion "Хочу сразу несколько самокатов! Так можно?"
    public static final By THREE_ACCORDION = By.id("accordion__heading-2");//Accordion "Как рассчитывается время аренды?"
    public static final By FOUR_ACCORDION = By.id("accordion__heading-3");//Accordion "Можно ли заказать самокат прямо на сегодня?"
    public static final By FIVE_ACCORDION = By.id("accordion__heading-4");//Accordion "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By SIX_ACCORDION = By.id("accordion__heading-5");//Accordion "Вы привозите зарядку вместе с самокатом?"
    public static final By SEVEN_ACCORDION = By.id("accordion__heading-6");//Accordion "Можно ли отменить заказ?"
    public static final By EIGHT_ACCORDION = By.id("accordion__heading-7");//Accordion "Я живу за МКАДом, привезёте?"

    //Локаторы панели с текстом для метода isDropdownTextCorrect
    public static final By PANEL_TEXT_ONE = By.id("accordion__panel-0");
    public static final By PANEL_TEXT_TWO = By.id("accordion__panel-1");
    public static final By PANEL_TEXT_THREE = By.id("accordion__panel-2");
    public static final By PANEL_TEXT_FOUR = By.id("accordion__panel-3");
    public static final By PANEL_TEXT_FIVE = By.id("accordion__panel-4");
    public static final By PANEL_TEXT_SIX = By.id("accordion__panel-5");
    public static final By PANEL_TEXT_SEVEN = By.id("accordion__panel-6");
    public static final By PANEL_TEXT_EIGHT = By.id("accordion__panel-7");

    //Текст который должен быть в поле для метода isDropdownTextCorrect
    public static final String TEXT_ELEM_ONE = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";//Accordion "Сколько это стоит? И как оплатить?"
    public static final String TEXT_ELEM_TWO = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";//Accordion "Хочу сразу несколько самокатов! Так можно?"
    public static final String TEXT_ELEM_THREE = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";//Accordion "Как рассчитывается время аренды?"
    public static final String TEXT_ELEM_FOUR = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";//Accordion "Можно ли заказать самокат прямо на сегодня?"
    public static final String TEXT_ELEM_FIVE = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";//Accordion "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final String TEXT_ELEM_SIX = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";//Accordion "Вы привозите зарядку вместе с самокатом?"
    public static final String TEXT_ELEM_SEVEN = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";//Accordion "Можно ли отменить заказ?"
    public static final String TEXT_ELEM_EIGHT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";//Accordion "Я живу за МКАДом, привезёте?"

    //Конструктор класса
    public DropdownQuestions(WebDriver driver){
        this.driver = driver;
    }

    //Метод скролла до вопросов
    public void scrollQuestionsDropdown(){

//Закрываем куки
        By cook = By.id("rcc-confirm-button");
        driver.findElement(cook).click();

//Скролл до вопросов
        WebElement element = driver.findElement(ONE_ACCORDION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    //Метод клика на Accordion элемент с вопросом
    public void clickDropdownArrow(By AccordionElement){

//Клик на вопрос
        driver.findElement(AccordionElement).click();

    }

    //Метод ожидания панели с текстом
    public void waitPanelElement(By panelElement){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelElement));
    }

    //Метод проверки выпадающего текста
    public void isDropdownTextCorrect(By panelElement, String textElement){
        String textElementAccordion = driver.findElement(panelElement).getText();
        MatcherAssert.assertThat(textElementAccordion, is(textElement));
    }

    //Шаг "Когда нажимаешь на стрелочку, открывается соответствующий текст."
    public void checkDropdownTextOpensOnArrowClick(By AccordionElement, By panelElement, String textElement){
        clickDropdownArrow(AccordionElement);
        waitPanelElement(panelElement);
        isDropdownTextCorrect(panelElement, textElement);
    }
}