package org.example.steps;
import io.cucumber.java.en.Then;
import org.junit.Assert;
// Clasa care conține pași generici pentru testele Cucumber
public class GenericSteps {
    /**
     * Verifică dacă pagina curentă conține un text specificat.
     * @param text Textul care trebuie căutat pe pagină
     *
     * Exemplu de utilizare în scenariul Cucumber:
     * Then the page should contain text "Welcome"
     */
    @Then("the page should contain text {string}")
    public void page_contains(String text){
        // Obține sursa paginii curente și o convertește în litere mici pentru comparație insensibilă la majuscule
        String source = SharedDriver.driver.getPageSource().toLowerCase();
        // Verifică dacă sursa paginii conține textul specificat
        Assert.assertTrue("Text not found: " + text, source.contains(text.toLowerCase()));
    }
}
