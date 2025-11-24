# Lab6 - Cucumber BDD + Selenium (project scaffold)

This project is a scaffold for the Laboratory #6 assignment: automate the tests created in Lab #3 (manual tests) using **Cucumber BDD** and **Selenium WebDriver** (Chrome).

**Target application (from Lab #3):** https://adoring-pasteur-3ae17d.netlify.app/mens.html

## What is included
- pom.xml (Maven)
- src/test/java/org/example/runner/TestRunner.java
- src/test/java/org/example/steps/* (Hooks, SharedDriver, steps for features)
- src/test/java/org/example/pages/* (BasePage, MensPage, ContactPage, ProductPage)
- src/test/resources/features/* (features for Contact, Search, Products, QuickView, CartPrice, Reviews)
- A ZIP archive of this project for easy import into IntelliJ.

## How to run
1. Import project into IntelliJ as a Maven project.
2. Make sure you have Java 17 and Chrome installed.
3. In IntelliJ: Right-click on `TestRunner.java` and Run. Maven will download dependencies.
4. Reports: an HTML report will be generated in `target/` by the Cucumber runner plugin entry in the runner configuration.

## Notes
- Selectors in Page Objects are intentionally written as generic CSS/XPath with comments. If a selector fails, open the target site and adjust the locator accordingly.
- No absolute file paths are used anywhere.
- Hooks use WebDriverManager to manage ChromeDriver binary automatically.
