package org.example.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Specifică faptul că această clasă va fi rulată cu JUnit folosind Cucumber
@RunWith(Cucumber.class)
// Configurațiile pentru Cucumber
@CucumberOptions(
        // Directorul unde se află fișierele .feature (scenariile BDD)
        features = "src/test/resources/features",
        // Pachetul în care se află clasele cu pașii definiți (step definitions)
        glue = {"org.example.steps"},
        // Plugin-uri pentru rapoarte: "pretty" afișează output în consolă frumos,
        // "html" generează raport HTML la locația specificată
        plugin = {"pretty", "html:target/cucumber-report.html"},
        // Afișează output-ul în consolă într-un format ușor de citit
        monochrome = true)

public class TestRunner {
    // Clasa nu conține metode deoarece Cucumber/JUnit rulează automat scenariile
}
