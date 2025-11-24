package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
// Clasa de bază pentru toate paginile aplicației
public class BasePage {
    // Driver-ul WebDriver utilizat pentru interacțiunea cu browser-ul
    protected WebDriver driver;
    // Constructorul clasei BasePage
    // Primește un driver și inițializează elementele paginii folosind PageFactory
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Inițializează elementele paginii
    }
    // Metodă pentru a returna driver-ul curent
    public WebDriver getDriver(){
        return this.driver;
    }
}
