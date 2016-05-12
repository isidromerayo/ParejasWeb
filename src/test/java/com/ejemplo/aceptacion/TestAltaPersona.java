package com.ejemplo.aceptacion;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(ConcordionRunner.class)
public class TestAltaPersona   {

	private WebDriver driver;
	private String baseUrl;
	
	public String testAlta(String nombre, String edad, String altura, String sexo ) {
		// Definir el SUT
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ejecutar la prueba
		driver.get(baseUrl + "ParejasWeb/");
		assertTrue(isElementPresent(By.name("nombre")));
		assertTrue(isElementPresent(By.name("edad")));
		assertTrue(isElementPresent(By.name("altura")));
		assertTrue(isElementPresent(By.name("sexo")));
		assertTrue(isElementPresent(By.name("buscar")));
		driver.findElement(By.name("nombre")).clear();
		driver.findElement(By.name("nombre")).sendKeys("fernando");
		driver.findElement(By.name("edad")).clear();
		driver.findElement(By.name("edad")).sendKeys("79");
		driver.findElement(By.name("altura")).clear();
		driver.findElement(By.name("altura")).sendKeys("1.79");
		driver.findElement(By.name("sexo")).clear();
		driver.findElement(By.name("sexo")).sendKeys("H");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		// el assert se realiza con lo que retornamos
		return "";
	}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
