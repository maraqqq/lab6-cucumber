package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Clasa care reprezintă pagina unui produs din site
public class ProductPage extends BasePage {

    // Titlul produsului (poate fi h1 cu clasa product-name sau alte clase generice)
    @FindBy(css = ".product-title, h1.product-name, .title")
    public WebElement productTitle;

    // Prețul produsului (poate fi clasa .product-price sau .price)
    @FindBy(css = ".product-price, .price")
    public WebElement productPrice;

    // Câmpul pentru introducerea unui review (textarea cu numele 'review' sau id 'review')
    @FindBy(css = "textarea[name='review'], #review")
    public WebElement reviewTextArea;

    // Butonul pentru trimiterea review-ului
    // Poate fi button cu clasa submit-review sau input de tip submit cu valoare conținând 'Review'
    @FindBy(css = "button.submit-review, input[type='submit'][value*='Review'], button[name*='review']")
    public WebElement submitReviewBtn;

    // Constructorul clasei ProductPage
    // Apelează constructorul clasei de bază BasePage pentru a inițializa driver-ul
    public ProductPage(WebDriver driver){
        super(driver);
    }
}
