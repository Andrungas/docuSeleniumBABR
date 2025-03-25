package com.ejercicio;
 // Ensure you have the Selenium dependencies added to your Maven or Gradle project.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Example {
    public static void main(String[] args) throws Exception {
        Path src = Path.of("source.txt");
        Path dest = Path.of("destination.txt");

        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
    }
}
import java.time.Duration;

public class SeleniumTest {@AfterMethod
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

    public class SeleniumTest {
        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            // Configuración del WebDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Configuración de WebDriverWait (tiempo de espera explícito)
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navegar a una URL de prueba
            driver.get("https://example.com");
        }

        @Test
        public void testExample() {
            // Ejemplo de espera explícita
            wait.until(ExpectedConditions.titleIs("Example Domain"));

            // Agregue más pasos de prueba aquí
            System.out.println("El título de la página es: " + driver.getTitle());
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit(); // Cerrar el navegador
            }
        }
    }
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
