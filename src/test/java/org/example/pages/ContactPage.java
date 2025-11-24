package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*
 * Obiectul paginii Contact - adaptează locatorii după cum este necesar
 */
public class ContactPage extends BasePage {
    // Localizator pentru titlul paginii (poate fi h1, h2 sau clasa .page-title)
    @FindBy(css = "h1, h2, .page-title")
    public WebElement pageTitle;
    // Constructorul clasei ContactPage
    // Apelează constructorul clasei de bază BasePage pentru a inițializa driver-ul
    public ContactPage(WebDriver driver){
        super(driver);
    }
}
