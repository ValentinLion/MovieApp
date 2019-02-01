package com.esir.projet_dlc;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
/**
 * Unit test for simple App.
 */
public class SeleniumAppTest extends TestCase {
	private WebDriver driver;
	private String URL = "http://148.60.11.117:8081/movie/";
	
	@BeforeClass
	public void setUp() throws Exception {

	    FirefoxBinary firefoxBinary = new FirefoxBinary();
	    firefoxBinary.addCommandLineOptions("--headless");
	    System.setProperty("webdriver.gecko.driver", "/home/geckodriver");
	    FirefoxOptions firefoxOptions = new FirefoxOptions();
	    firefoxOptions.setBinary(firefoxBinary);
	    driver = new FirefoxDriver(firefoxOptions);
	}

	public void testGoOnSite() throws Exception {
		driver.get(URL + "liste");
		assertEquals(URL + "liste", driver.getCurrentUrl());
	}

	public void testSearch() {
		driver.get(URL + "liste");
		WebElement element = driver.findElement(By.name("query"));
        element.sendKeys("test");
		driver.findElement(By.cssSelector("button:nth-child(2)")).click();
		assertEquals(URL + "search", driver.getCurrentUrl());
	}
	
	public void testMoviePage() {
		driver.get(URL + "liste");
		driver.findElement(By.id("poster11")).click();
		assertEquals(URL + "film?id=11", driver.getCurrentUrl());
	}
	
	public void testNextPage() {
		driver.get(URL + "liste");
		driver.findElement(By.cssSelector(".next")).click();
		assertEquals(URL + "liste?page=2", driver.getCurrentUrl());
	}
	
	public void testSwitchPage() {
		driver.get(URL + "liste");
		driver.findElement(By.cssSelector(".page-number:nth-child(6)")).click();
		assertEquals(URL + "liste?page=5", driver.getCurrentUrl());
	}
	
	public void testAccueilButton() {
		driver.get(URL + "film?id=4");
		driver.findElement(By.linkText("Accueil")).click();
		assertEquals(URL + "liste", driver.getCurrentUrl());
	}
	
	public void testHomeButton() {
		driver.get(URL + "film?id=4");
		driver.findElement(By.linkText("Liste des films")).click();
		assertEquals(URL + "liste", driver.getCurrentUrl());
	}
	
	public void testSiteBanner() {
		driver.get(URL + "film?id=4");
		driver.findElement(By.cssSelector(".site-title")).click();
		assertEquals(URL + "liste", driver.getCurrentUrl());
	}
	
	public void testFindMovieButton() {
		driver.get(URL + "film?id=4");
		driver.findElement(By.linkText("Trouver un film")).click();
		assertEquals(URL + "liste", driver.getCurrentUrl());
	}
	
	public void testAddMovieButton() {
		driver.get(URL + "film?id=4");
		driver.findElement(By.linkText("Ajouter un film")).click();
		assertEquals(URL + "addMovie", driver.getCurrentUrl());
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static TestSuite suite()
	{
	    return new TestSuite( SeleniumAppTest.class );
	}
}


