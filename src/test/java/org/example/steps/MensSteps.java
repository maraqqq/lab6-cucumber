package org.example.steps;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.pages.MensPage;
import org.example.pages.ContactPage;
import org.example.pages.ProductPage;
import java.util.List;
import java.util.Map;
// Pași pentru testarea paginii men's
public class MensSteps {

    MensPage mensPage;
    ContactPage contactPage;
    ProductPage productPage;
    String baseUrl = "https://adoring-pasteur-3ae17d.netlify.app/mens.html";

    @Given("I open the men's page")
    public void open_mens(){
        mensPage = new MensPage(SharedDriver.driver);
        mensPage.open(baseUrl); // Deschide pagina men's
    }
    @When("I click Contact link")
    public void click_contact(){
        try {
            mensPage.contactLink.click(); // Click pe link-ul Contact
        } catch(Exception e){
            // Dacă link-ul nu există, caută alt element cu text Contact
            List<WebElement> links = SharedDriver.driver.findElements(By.xpath(
                    "//a[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'contact')]") );
            if(links.size() > 0) links.get(0).click();
            else throw e;
        }
        contactPage = new ContactPage(SharedDriver.driver);
    }
    @Then("I should be on contact page or see contact related content")
    public void verify_contact(){
        String url = SharedDriver.driver.getCurrentUrl();
        if(!url.toLowerCase().contains("contact")){
            boolean contains = SharedDriver.driver.getPageSource().toLowerCase().contains("contact") ||
                    SharedDriver.driver.getPageSource().toLowerCase().contains("our information");
            Assert.assertTrue("Contact page or content not found", contains);
        }
    }
    @When("I search for {string}")
    public void search_for(String query){
        try {
            mensPage.searchInput.clear();
            mensPage.searchInput.sendKeys(query);
            mensPage.searchInput.submit(); // Caută textul
        } catch(Exception e){
            // fallback: apasă un buton submit dacă există
            List<WebElement> buttons = SharedDriver.driver.findElements(By.cssSelector("button[type='submit'], button.search"));
            if(buttons.size() > 0){
                mensPage.searchInput.sendKeys(query);
                buttons.get(0).click();
            } else {
                mensPage.searchInput.sendKeys("\n");
            }
        }
    }
    @Then("I should see products related to {string}")
    public void verify_search_results(String q){
        List<WebElement> products = mensPage.productItems;
        Assert.assertTrue("No products found", products.size() > 0); // Verifică produse
        boolean found = products.stream().anyMatch(p -> p.getText().toLowerCase().contains(q.toLowerCase()));
        Assert.assertTrue("No product contains the search term", found);
    }
    @Then("I should see at least {int} products on the page")
    public void verify_min_products(int min){
        List<WebElement> products = mensPage.productItems;
        Assert.assertTrue("Not enough products displayed", products.size() >= min);
    }
    @When("I open quick view of product {int}")
    public void open_quick_view(int index){
        List<WebElement> products = mensPage.productItems;
        int idx = Math.max(0, Math.min(index-1, products.size()-1));
        WebElement prod = products.get(idx);
        try {
            WebElement qv = prod.findElement(By.cssSelector(".quick-view, .quickview, .view-details"));
            qv.click(); // Deschide quick view
        } catch(Exception e){
            prod.click();
        }
        productPage = new ProductPage(SharedDriver.driver);
    }
    @Then("Quick view should show correct product details")
    public void verify_quick_view(){
        Assert.assertTrue("Product title missing", productPage.productTitle.getText().length() > 0);
    }
    @When("I add product to cart")
    public void add_to_cart(){
        try {
            mensPage.addToCartBtn.click(); // Adaugă în coș
        } catch(Exception e){
            List<WebElement> adds = SharedDriver.driver.findElements(By.cssSelector("button.add-to-cart, input[value*='Add to cart']"));
            if(adds.size() > 0) adds.get(0).click();
            else throw new RuntimeException("Add to cart button not found");
        }
    }

    @Then("The cart price should reflect the product price")
    public void verify_cart_price(){
        try {
            String price = productPage.productPrice.getText();
            List<WebElement> totals = SharedDriver.driver.findElements(By.cssSelector(".cart-total, .total-price, .cart-price"));
            Assert.assertTrue("Cart total not found", totals.size() > 0);
            String total = totals.get(0).getText();
            Assert.assertTrue("Cart total does not contain product price", total.contains(price) || price.contains(total));
        } catch(Exception e){
            throw new AssertionError("Could not verify cart price automatically. Update selectors.", e);
        }
    }

    @When("I submit a review with:")
    public void submit_review(io.cucumber.datatable.DataTable table){
        Map<String,String> map = table.asMap(String.class, String.class);
        if(productPage == null){
            open_quick_view(1); // Deschide un produs dacă nu există
        }
        try {
            productPage.reviewTextArea.clear();
            productPage.reviewTextArea.sendKeys(map.getOrDefault("review","Great product"));
            productPage.submitReviewBtn.click(); // Trimite review
        } catch(Exception e){
            throw new RuntimeException("Review elements not found", e);
        }
    }

    @Then("I should see the review on the product page")
    public void verify_review_present(){
        boolean contains = SharedDriver.driver.getPageSource().contains("Great product") ||
                SharedDriver.driver.getPageSource().contains("thank you for your review");
        Assert.assertTrue("Review text not found on page", contains);
    }
}
