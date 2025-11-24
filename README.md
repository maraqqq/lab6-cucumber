Lab6 – Cucumber BDD + Selenium
Acest proiect reprezintă scheletul pentru tema Laboratorului #6: automatizarea testelor create în Lab #3 (teste manuale) folosind Cucumber BDD și Selenium WebDriver (Chrome).
Aplicația țintă (din Lab #3): https://adoring-pasteur-3ae17d.netlify.app/mens.html

Ce conține proiectul
pom.xml (Maven)
src/test/java/org/example/runner/TestRunner.java
src/test/java/org/example/steps/* (Hooks, SharedDriver, pașii pentru feature-uri)
src/test/java/org/example/pages/* (BasePage, MensPage, ContactPage, ProductPage)
src/test/resources/features/* (feature-uri pentru Contact, Căutare, Produse, QuickView, Preț Coș, Recenzii)
Un fișier ZIP al proiectului pentru import ușor în IntelliJ.

Cum se rulează
Importă proiectul în IntelliJ ca proiect Maven.
Asigură-te că ai instalat Java 17 și Chrome.
În IntelliJ: Click dreapta pe TestRunner.java → Run. Maven va descărca automat dependențele necesare.
Rapoarte: un raport HTML va fi generat în folderul target/ prin pluginul Cucumber configurat în runner.

Observații
Selectorii din Page Objects sunt scriși intenționat generic (CSS/XPath) și au comentarii explicative. Dacă un selector nu funcționează, deschide site-ul țintă și ajustează locatorul corespunzător.
Nu se folosesc căi absolute către fișiere.
Hooks folosesc WebDriverManager pentru a gestiona automat binarul ChromeDriver.
