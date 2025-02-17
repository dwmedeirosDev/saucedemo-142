// Imports

// JUnit
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Classe
public class VerificacaoCarrinhoComprasTest {
  private WebDriver driver;

  @BeforeEach // Executa antes de cada teste
  public void setUp() {
    driver = new ChromeDriver();
  }

  @AfterEach // Executa após cada teste
  public void tearDown() {
    driver.quit();
  }

  @Test // Teste
  public void verificacaoCarrinhoCompras() {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().setSize(new Dimension(1062, 804));
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();

    // ============ transição de página ============

    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();

    // ============ transição de página ============

    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"item-quantity\"]")).getText(), ("1"));
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), ("Sauce Labs Backpack"));
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), ("$29.99"));
  }
}
