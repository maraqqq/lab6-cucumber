package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class MensPage extends BasePage {
    // Câmpul de căutare din header (input cu placeholder "Search here...")
    @FindBy(css = "input[placeholder='Search here...']")
    public WebElement searchInput;
    // Lista de produse (div-uri cu clase generice pentru produse)
    @FindBy(css = ".product, .product-item, .product-card, .box")
    public List<WebElement> productItems;
    // Link către pagina Contact din meniu
    @FindBy(css = "a[href*='contact']")
    public WebElement contactLink;
    // Buton "Adaugă în coș" pentru produse
    @FindBy(css = "button.add-to-cart, .add-to-cart")
    public WebElement addToCartBtn;
    // Constructorul clasei MensPage
    public MensPage(WebDriver driver) {
        super(driver);
    }
    // Metodă pentru a deschide un URL specific
    public void open(String url){
        driver.get(url);
    }
}
