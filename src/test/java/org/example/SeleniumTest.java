//package com.ejercicio;
/*package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
*/


package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

// Importaciones para grabación de pantalla
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import java.awt.*;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private org.monte.screenrecorder.ScreenRecorder screenRecorder;

    @BeforeClass
    public void setUp() throws Exception {


        // Configurar EdgeDriver con WebDriverManager
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled"); // Evita detección como bot
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        // Configurar esperas globales
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void testBingSearch() throws IOException{
        try {
            // Navegar a Google
            driver.get("https://www.google.com");

            // Espera la barra de busqueda sea visible
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));


            searchBox.sendKeys("Documentacion de Selenium");
            searchBox.sendKeys(Keys.RETURN);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));

            //screen de resultados
            takeScreenshot("google_search_results.png");

            //enlace de la documentación de Selenium
            WebElement seleniumLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Selenium')]")));
            seleniumLink.click();
//            WebElement seleniumLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Selenium')]")));
//            seleniumLink.click();

            // Espera que cargue la página de documentacion de Selenium
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar")));

            // Captura de pantalla de la documentación de Selenium
            takeScreenshot("selenium_documentation.png");


            //navigateSidebarMenu();
        } catch (Exception e) {
            String mainWindowHadle = driver.getWindowHandle();
            takeScreenshot("Documentation.png");
            WebElement frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationoverview']")));
            frameSelector.click();
            takeScreenshot("overview.png");
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationwebdriver']")));
            frameSelector.click();
            takeScreenshot("WebDriver.png");
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationselenium_manager']")));
            frameSelector.click();
            takeScreenshot("SeleniumManager.png");
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationgrid']")));
            frameSelector.click();
            takeScreenshot("GRID.png");
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationie_driver_server']")));
            frameSelector.click();
            takeScreenshot("IE_Driver_srvr.png");
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationide']")));
            frameSelector.click();
            takeScreenshot("IDE.png");
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationtest_practices']")));
            frameSelector.click();
            takeScreenshot("Test_PRactices.png");
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationlegacy']")));
            frameSelector.click();
            takeScreenshot("Legacy.png");
            //frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='m-documentationabout']")));
            frameSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"m-documentationabout\"]")));

            frameSelector.click();
            takeScreenshot("10.About.png");
        }
    }


    public void takeScreenshot(String fileName) throws IOException {
        // Castear el WebDriver a TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        //se obtiene screen y se guarda
        File source = ts.getScreenshotAs(OutputType.FILE);
        //se crea la carpeta screenshots
        File destination = new File("./screenshots/" + fileName);

        // Guardar el archivo en el directorio deseado
        FileHandler.copy(source, destination);
    }

    @AfterClass
    public void tearDown() throws Exception {
        //detener grabacion de pantalla

    //    stopRecording();

        //cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
    }

    //metodos para la grabación de pantalla y creacion de carpeta
//    public void startRecording() throws Exception {
//        File file = new File("./Grabacion/");
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//
//        //se evitan ambigüedades con los nombres de clases
//        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        java.awt.Rectangle captureSize = new java.awt.Rectangle(0, 0, screenSize.width, screenSize.height);
//
//        GraphicsConfiguration gc = GraphicsEnvironment
//                .getLocalGraphicsEnvironment()
//                .getDefaultScreenDevice()
//                .getDefaultConfiguration();

        /*
        screenRecorder = new org.monte.screenrecorder.ScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_MJPG,
                        CompressorNameKey, ENCODING_AVI_MJPG,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(30),
                        QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file);

        screenRecorder.start();
        System.out.println("Grabacion iniciada...");
    }

    public void stopRecording() throws Exception {
        if (screenRecorder != null) {
            screenRecorder.stop();
            System.out.println("Grabación detenida.");
        }  */
   // }
}
